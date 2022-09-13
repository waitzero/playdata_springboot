package com.coding404.myweb.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coding404.myweb.command.UsersVO;
import com.coding404.myweb.user.service.UserService;

@RestController
public class AjaxController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/idCheck")
	public int idCheck(@RequestBody String id, UsersVO vo) {
	
		
		return userService.idCheck(vo);
	}
}
