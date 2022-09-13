package com.coding404.myweb.user.service;

import com.coding404.myweb.command.UsersVO;

public interface UserService {
	public int idCheck(UsersVO vo);
	public int join(UsersVO vo);
	public UsersVO login(UsersVO vo);
}
