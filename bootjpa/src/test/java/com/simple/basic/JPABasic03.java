package com.simple.basic;

import java.util.Arrays;
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
public class JPABasic03 {

	@Autowired
	MemoRepository memoRepository;
	
	//쿼리메서드 - 메서드명이 sql문을 결정함
//	@Test
//	public void testCode01() {
//		
//		List<Memo> list = memoRepository.findByMnoBetween(10L, 20L);
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
//	@Test
//	public void testCode02() {
//		
//		//List<Memo> list = memoRepository.findByTextOrderByMnoDesc("test9");
//		//List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(10L, 20L);
//		//List<Memo> list = memoRepository.findByTextLikeOrWriterLike("%9%", "%7%");
//		List<Memo> list = memoRepository.findByTextIn( Arrays.asList("test9", "test29", "test39")  );
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//		
//	}
	
	
	//쿼리메서드와 + 페이지객체 조합
	@Test
	public void testCode03() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending() );
		
		Page<Memo> memo = memoRepository.findByTextLikeOrWriterLike("%7%", "%9%", pageable);
		
		//출력
		for(Memo m  : memo.getContent() ) {
			System.out.println(m.toString());
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
