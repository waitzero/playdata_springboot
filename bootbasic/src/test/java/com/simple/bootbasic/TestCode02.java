package com.simple.bootbasic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.bootbasic.command.BuilderVO;
import com.simple.bootbasic.command.BuilderVO.Builder;
import com.simple.bootbasic.command.BuilderVO2;

@SpringBootTest
public class TestCode02 {

	@Test
	public void testcode01() {
		
//		Builder vo = BuilderVO.builder();
//		vo = vo.name("홍길동");
//		vo = vo.age(10);
		
		BuilderVO vo = BuilderVO.builder().name("홍길동").age(10).build();
		System.out.println(vo.toString());
		
		BuilderVO2 vo2 = BuilderVO2.builder().name("이순신").age(10).build();
		System.out.println(vo2.toString());
		
		
		
		
	}
	
	
}
