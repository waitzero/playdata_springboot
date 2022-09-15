package com.coding404.myweb.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.UsersVO;

@Service("userService") 
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
		
	@Override
	public int idCheck(UsersVO vo) {
		return userMapper.idCheck(vo);
	}

	@Override
	public int join(UsersVO vo) {
		return userMapper.join(vo);
	}

	@Override
	public UsersVO login(UsersVO vo) {
		return userMapper.login(vo);
	}

}
