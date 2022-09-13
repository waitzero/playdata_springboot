package com.simple.bootbasic.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.bootbasic.command.BoardVO;

@Service("boardService") //이름명시 
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	
	@Override
	public int regist(BoardVO vo) {
		return boardMapper.regist(vo);
	}


	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}


	@Override
	public BoardVO getDetail(int bno) {
		return boardMapper.getDetail(bno);
	}
	
	

}
