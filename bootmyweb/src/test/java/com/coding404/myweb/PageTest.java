package com.coding404.myweb;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.coding404.myweb.entity.Notice;
import com.coding404.myweb.entity.QNotice;
import com.coding404.myweb.notice.service.NoticeRepository;
import com.coding404.myweb.util.page.Criteria;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@SpringBootTest
public class PageTest {

	@Autowired
	NoticeRepository noticeRepository;
	
//	@Test
//	public void testCode01() {
//		
//		for(int i = 1; i <= 300; i++) {
//			
//			Notice notice = Notice.builder().noticedate("2022-09-16")
//											.writer("test" + i)
//											.title("test" + i)
//											.content("test" + i)
//											.build();
//			
//			noticeRepository.save(notice);
//		}
//	}
	
//	@Test
//	public void testCode02() {
//		
//		//Criteria cri = new Criteria(); //1, 10
//		Criteria cri = new Criteria(5, 10);
//		
//		
//		Pageable pageable = PageRequest.of( cri.getPage() - 1,
//											cri.getAmount(),
//											Sort.by("nno").descending() ); 
//		
//		Page<Notice> result = noticeRepository.findAll(pageable);
//
//		for(Notice n : result.getContent() ) {
//			System.out.println(n.toString());
//		}
//		
//		System.out.println("페이지번호:" + (result.getNumber() + 1) ); //1번 페이지가 0으로 동작되기 때문에
//		System.out.println("amount값:" + result.getSize());
//		System.out.println("전체게시글수:" + result.getTotalElements());
//		System.out.println("실제끝페이지번호:" + result.getTotalPages());
//		
//	}
	
	@Test
	public void testCode03() {
		Criteria cri = new Criteria(1, 10);
		
		Pageable pageable = PageRequest.of( cri.getPage() - 1,
											cri.getAmount(),
											Sort.by("nno").descending() );
		
		//Q클래스를 얻는 방법
		QNotice qNotice = QNotice.notice;
		
		//조건을 합치는 객체
		BooleanBuilder builder = new BooleanBuilder();
		//조건을 기술
		//BooleanExpression express = qNotice.writer.eq("admin");
		//불린 빌더에 express를 합침 - (and, or)를 이용해서 합쳐준다.
		//builder.and(express);

		//2번쨰 조건
		BooleanExpression express;
		
		express = qNotice.content.like("%admin%");
		builder.and(express);
		
		//3번째 조건
		express = qNotice.title.like("%2%");
		builder.and(express);
		
		//4번째 조건
		express = qNotice.writer.like("%3%");
		builder.and(express);
		
		Page<Notice> result = noticeRepository.findAll(builder, pageable);
		
		for(Notice n : result.getContent()) {
			System.out.println(n.toString());
		}
		
		
	}
	
	
	
	
	
	
}
