package com.simple.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.simple.basic.entity.Memo;
import com.simple.basic.repository.MemoRepository;

@SpringBootTest
public class JPABasic02 {
	//Sort - 오더 클래스
	//PageRequest - limit클래스
		
	@Autowired
	MemoRepository memoRepository;
	
	//정렬 
//	@Test
//	public void testCode01() {
//		
//		Sort order = Sort.by("mno").descending(); //mno desc
//		
//		List<Memo> list = memoRepository.findAll(order);
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
	//정렬 and
//	@Test
//	public void testCode02() {
//		//select * from tbl_memo order by writer desc, text asc
//		
//		Sort order01 = Sort.by("writer").descending();
//		Sort order02 = Sort.by("text").ascending();
//		
//		Sort order = order01.and(order02); //and로 조건을 합침
//		
//		List<Memo> list = memoRepository.findAll(order);
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//				
//	}
	
	//페이지클래스 - limit
//	@Test
//	public void testCode03() {
//		
//		//select * from tbl_memo limit 0, 10
//		//PageRequest page = PageRequest.of(0, 10);
//		//Pageable은 부모인터페이스 타입
//		Pageable page = PageRequest.of(0, 10);
//		
//		//페이지에 필요한 정보들을 반환
//		Page<Memo> memo = memoRepository.findAll(page);
//		
//		//Page인터페이스에서 조회된 데이터를 얻음★
//		List<Memo> list = memo.getContent();
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//		
//		System.out.println("현재 페이지번호:" + memo.getNumber() ); 
//		System.out.println("총 페이지수:" + memo.getTotalPages() );
//		System.out.println("총 데이터수:" + memo.getTotalElements() );
//		System.out.println("데이터 존재여부:" + memo.hasContent() );
//		System.out.println("amount값:" + memo.getSize() );
//	}
	
	
	//페이지 + sort
	@Test
	public void testCode04() {
		
		Pageable page = PageRequest.of(1, 10, Sort.by("mno").descending() ); // (페이지번호, 데이터크기, sort)
		
		Page<Memo> memo = memoRepository.findAll(page);
		
		for(Memo m : memo.getContent() ) {
			System.out.println(m.toString());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
