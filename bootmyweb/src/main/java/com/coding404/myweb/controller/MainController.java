package com.coding404.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/main")
	public String home(HttpSession session) {
		//세션검사
//		String userId = (String)session.getAttribute("userId");
//		if(userId == null) {
//			return "redirect:/user/login";
//		}
				
		
		return "main";
	}
	
	
}
