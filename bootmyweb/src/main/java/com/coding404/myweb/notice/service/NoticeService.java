package com.coding404.myweb.notice.service;

import java.util.List;

import com.coding404.myweb.entity.Notice;
import com.coding404.myweb.util.page.Criteria;
import com.coding404.myweb.util.page.PageDTO;

public interface NoticeService {

	Notice noticeReg(Notice notice); //등록
	//List<Notice> getList(); //모든목록
	PageDTO<Notice> getList(Criteria cri); //페이지
	
	Notice getDetail(Long nno); //상세화면
	
	List<Notice> getListMe(String writer); //나의목록
	Notice noticeUpdate(Notice notice); //내글수정
	void noticeDelete(Long nno); //내글삭제
	
}
