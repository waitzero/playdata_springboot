package com.coding404.myweb.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthHandler implements HandlerInterceptor {
	
	//오버라이딩
	//prehandler - 컨트롤러 실행전에 동작함
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//로그인 시점에서 저장되는 세션값
		HttpSession session = request.getSession();
		//String userId = (String)session.getAttribute("userId");
		
		//개발단계에서는 가짜 아이디로 세션을 등록
		session.setAttribute("userId", "admin");
		session.setAttribute("userName", "홍길동");
		String userId = (String)session.getAttribute("userId");
		
		
		if(userId == null) { 
			response.sendRedirect("/user/login"); //로그인화면으로
			return false; //컨트롤러를 실행하지 않음
		} else {
			return true; //컨트롤러를 실행함
		}
		
	}

	
}
