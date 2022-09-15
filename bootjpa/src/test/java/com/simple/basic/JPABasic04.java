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
public class JPABasic04 {

	@Autowired
	MemoRepository memoRepository;
	
//	@Test
//	public void testCode01() {
//		
//		List<Memo> list = memoRepository.getListDesc();
//		
//		for(Memo m: list) {
//			System.out.println(m.toString());
//		}
//		
//	}
	
//	
//	@Test
//	public void testCode02() {
//		
//		List<Memo> list = memoRepository.getListDesc2(100L);
//		for(Memo m : list) {
//			System.out.println(m.toString());
//			
//		}
//		@Test
//		public void testCode03() {
//			
//			List<Object[]> list = memoRepository.getListDesc3();
//			for(Object[] arr : list ) {
//				System.out.println(arr[0]+","+arr[1]+","+arr[2]+",");
//				
//			}
//	@Test
//	public void testCode04() {
//		
//		List<Memo> list =memoRepository.getListLike("9");
//		for(Memo m :list) {
//		System.out.println(m.toString());
//		}
//		@Test
//		public void testCode05() {
//		int result	= memoRepository.updateMemo("변경됨", 50L);
//		System.out.println("성공실패"+ result);
//		}
//		@Test
//		public void testCode06() {
//		Memo memo = Memo.builder().mno(51L)
//		.writer("변경됨")
//		.text("변경됨")
//		.build();
//		int result = memoRepository.updateObj(memo);
//		}
	
//	@Test
//	private void testCVode07() {
//		// TODO Auto-generated method stub
//		Pageable pageable = PageRequest.of(1, 10, Sort.by("mno").descending());
//		Page<Memo>memo =memoRepository.getListpage(100L, pageable);
//	
//		for(Memo m:memo.getContent()) {
//			System.out.println(m.toString());
//		}
//	}
	@Test
	public void testCode08() {
		Memo m = memoRepository.getNative(100L);
		System.out.println(m.toString());
	}
		}
	
	
	
	
	
