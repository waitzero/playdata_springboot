package com.coding404.myweb.notice.service;

import java.util.List;

import com.coding404.myweb.entity.Notice;

public interface NoticeService {

	Notice noticeReg(Notice notice); //등록
	List<Notice> getList(); //모든목록
	Notice getDetail(Long nno); //상세화면
	
	List<Notice> getListMe(String writer); //나의목록
	
	Notice noticeUpdate(Notice notice);
	void noticeDelete(Long nno);
	
	
	
}
