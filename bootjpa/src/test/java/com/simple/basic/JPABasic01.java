package com.simple.basic;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.entity.Memo;
import com.simple.basic.repository.MemoRepository;

@SpringBootTest
public class JPABasic01 {

	@Autowired
	MemoRepository memoRepository;
	
//	@Test
//	public void testCode01() {
//		
//		for(int i = 1; i <= 300; i++) {
//			Memo memo = Memo.builder().writer("admin" + i)
//					  .text("test" + i)
//					  .build();
//	
//			memoRepository.save(memo);
//		}
//	}
	
	//select작업 - find로 시작
//	@Test
//	public void testCode02() {
//		
//		Optional<Memo> result = memoRepository.findById(100L); //100번조회
//		
//		if( result.isPresent()  ) { //있다면 true, 없다면 false
//			
//			Memo memo = result.get();
//			System.out.println(memo.toString()); //조회된 결과
//		}
//	}
	
	//select작업
//	@Test
//	public void testCode03() {
//		
//		List<Memo> list = memoRepository.findAll();
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
	
	//update작업 -save(엔티티)
//	@Test
//	public void testCode04() {
//		
//		//100번 데이터 수정
//		//내부적으로 select로 해당번호를 확인하고, 업데이트를 진행해줍니다.
//		//만약에 값이 없다면 insert로 진행시킵니다.
//		Memo memo = Memo.builder().mno(100L)
//								  .writer("수정됨")
//								  .text("수정됨")
//								  .build();
//		
//		Memo result = memoRepository.save(memo);
//		System.out.println(result.toString());
//		
//	}
	
	//delete작업 - deletebyId
	@Test
	public void testCode05() {
		memoRepository.deleteById(101L); //삭제
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
