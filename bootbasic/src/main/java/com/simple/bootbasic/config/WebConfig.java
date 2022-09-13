package com.simple.bootbasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.bootbasic.controller.HomeController;
import com.simple.bootbasic.util.UtilConponent;

@Configuration //스프링 설정파일로 사용
public class WebConfig implements WebMvcConfigurer{

	/*
	 * 스프링부트에서 부가적인 빈설정을 하는 방법.
	 *  applicationContext는 스프링 빈을 담당하는 IOC컨테이너 입니다.
	 */
	
	
//	@Autowired
//	ApplicationContext applicationContext;
//	
//	//aplication.properties에 값을 자바문서로 읽는방법
//	@Value("${server.port}")
//	String port;
//	
//	@Value("${spring.project.dir}")
//	String filepath;
//	
//
//	
//	@Bean 
//	public void test() {
//		System.out.println("빈의개수:" + applicationContext.getBeanDefinitionCount());
//		//컨트롤러 빈을 꺼냄
//		HomeController home = applicationContext.getBean(HomeController.class);
//		System.out.println( home.home() );
//		
//		//utilcomponent 빈을 꺼냄
//		UtilConponent com = applicationContext.getBean(UtilConponent.class);
//		System.out.println(com);
//		
//		//aplication.properties에 값을 자바문서로 읽는방법
//		System.out.println(port);
//		
//		System.out.println(filepath);
//		
//	}
//	
//	//자바문법으로 bean등록하는 모형
//	@Bean
//	public UtilConponent utilConponent() {
//		return new UtilConponent();
//	}
	
	
	
	
	
	
	
	
}
