package com.simple.bootbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HomeController {

	@RequestMapping("/index")
	public String home() {
		
		return "index"; //화면에 대한 경로
	}
	
	
}
