package com.coding404.myweb.user.service;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.UsersVO;

@Mapper
public interface UserMapper {
	
	public int idCheck(UsersVO vo); //중복체크(REST방식)
	public int join(UsersVO vo);
	public UsersVO login(UsersVO vo);
}
