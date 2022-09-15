package com.coding404.myweb.user.service;

import com.coding404.myweb.command.UsersVO;

public interface UserService {

	public int idCheck(UsersVO vo); //중복체크(REST방식)
	public int join(UsersVO vo); //가입 
	public UsersVO login(UsersVO vo); //로그인
}
