package com.simple.bootbasic.service.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.bootbasic.command.BoardVO;

@Mapper //마이바티스의 매퍼임을 명시
public interface BoardMapper {
	
	public String getTime(); //test메서드
	public int regist(BoardVO vo); //insert
	public List<BoardVO> getList(); //select
	public BoardVO getDetail(@Param("xxx") int bno); //단, 전달하는 매개변수가 2개 이상일때 사용
}
