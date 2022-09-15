package com.coding404.myweb.notice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coding404.myweb.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> { //<엔티티, PK타입>
	
	//쿼리메서드
	Page<Notice> findByWriter(String writer, Pageable pageable);
	//JPQL
	@Query("select n from Notice n where n.writer = :a")
	Page<Notice> getListMe(@Param("a") String writer, Pageable pageable);
	
	
}
