package com.simple.bootbasic.service.memo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.bootbasic.command.MemoVO;

@Mapper
public interface MemoMapper {
	
	public void memoInsert(MemoVO vo);
	public List<MemoVO> getList();
	public MemoVO getDetail(int mno);
}
