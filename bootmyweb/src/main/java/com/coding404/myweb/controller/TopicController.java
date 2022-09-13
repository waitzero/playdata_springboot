package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice1")
public class TopicController {
	//여러분의 몫~
	@GetMapping({"/topicDetail",
				 "/topicListAll",
				 "/topicListMe",
				 "/topicModify",
				 "/topicReg"
				})		
	public void view() {
	
	}
	
	
	
	
}
