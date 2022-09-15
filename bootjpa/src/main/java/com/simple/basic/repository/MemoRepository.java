package com.simple.basic.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simple.basic.entity.Memo;

//DAO의 인터페이스 
public interface MemoRepository extends JpaRepository<Memo, Long> { //<엔티티, PK타입>
	
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	//쿼리메서드 - 메서드명이 sql문을 결정함
	List<Memo> findByMnoBetween(Long start, Long end);
	
	//select * from tbl_memo where text = ? order by mno desc
	List<Memo> findByTextOrderByMnoDesc(String a);
	
	//1
	//select * From 테이블 where mno between ? and ? order by mno desc;
	List<Memo> findByMnoBetweenOrderByMnoDesc(Long start, Long end);
	//2
	//select * from 테이블 where text like '%?%' or writer like '%?%';
	List<Memo> findByTextLikeOrWriterLike(String a, String b);
	//3
	//select * from 테이블 where text in (?, ?, ?)
	List<Memo> findByTextIn(List<String> list); 
	
	//쿼리메서드와 PageRequest의 결합 
	//마지막 매개변수로 Pageable클래스를 넣으면됩니다.
	//반환유형은 Page<엔티티> 타입으로 받는다.
	Page<Memo> findByTextLikeOrWriterLike(String a, String b, Pageable pageable);
	
	
	//////////////////////////JPQL////////////////////////////
	//sql문과 유사하나 엔티티를 사용해서 쿼리를 직접 작성하는 방법
	
	//1. 엔티티명을 from절 하위로 적는다
	//2. 엔티티명에 대한 별칭을 사용
	//3. *는 별칭명으로 대체됨
	//4. 속성을 사용할때는 별칭.속성명
	@Query("select m from Memo m order by m.mno desc")
	List<Memo> getListDesc();
	
	//5. 파라미터의 표현 :이름, @Param("이름")
	@Query("select m from Memo m where m.mno > :num order by m.mno desc")
	List<Memo> getListDesc2(@Param("num") Long num);
	//6.select구문에 값은 선별적으로ㅓ 지정해서 받으려면 Object[]을 사용
	@Query("select m.mno, m.writer, current_timestamp from Memo m where m.mno > :num order by m.mno desc")
	List<Object[]> getListDesc3(@Param("num") Long num);
	//7. select * from tbl_memo where writer like '파라미터값';
	@Query("select m from tbl_memo m where m.write like '%:s%'")
	List<Memo> getListLike(@Param("s")String s);
	//Jpql은 insert구문은 제공 x
	//업데이트는 @Transcation, @Modifying으로
	@Transactional
	@Modifying
	@Query("update Memo m set m.writer = :a where m.mno = :b")
	int updateMemo(@Param("a") String a, @Param("b") Long b);
	//업데이트 구문 객체파라미터 사용 :#{#이름, 속성명}
	@Transactional
	@Modifying
	@Query("update Memo m set m.writer = :#{a.writer}, m.text =:m{#a.text} where m.mnop =:#{#a.mno}")
	int updateObj(@Param("a")Memo memo);
	
	@Query("select m from Memo m where m.mno> :a order m.mno desc")
	Page<Memo> getListpage(@Param("a")Long mno, Pageable pageable);
	
	//네이티브 쿼리(기존 sql문 사용)(
	@Query(value="select * from tbl_memo where mno =?", nativeQuery = true)
	Memo getNative(Long memo);
	
	
	
	
	
	
	
	
	
}
