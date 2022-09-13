package com.simple.bootbasic;

import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.bootbasic.service.board.BoardMapper;

@SpringBootTest
public class TestCode03 {

	//인터페이스에 @Mapper //마이바티스의 매퍼임을 명시
	@Autowired
	BoardMapper boardMapper;

	@Test
	public void testcode01() {
		
		String time = boardMapper.getTime();
		System.out.println(time);
		
	}
	
}
