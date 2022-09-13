package com.simple.bootbasic.service.board;

import java.util.List;

import com.simple.bootbasic.command.BoardVO;

public interface BoardService {

	public int regist(BoardVO vo); //insert
	public List<BoardVO> getList(); //select
	public BoardVO getDetail(int bno); //select
}
