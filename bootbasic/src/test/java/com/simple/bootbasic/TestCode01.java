package com.simple.bootbasic;

import java.sql.Connection;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class TestCode01 {

	@Autowired
	ApplicationContext app;
	
	
	@Test
	public void test01() {
		//System.out.println("테스트코드1");
		
		//데이터베이스 연결 정보
		DataSource ds = app.getBean(DataSource.class);
		
		try {
			Connection conn = ds.getConnection();
			System.out.println("DB연결정보:" + conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
