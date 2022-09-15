package com.coding404.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding404.myweb.entity.Notice;
import com.coding404.myweb.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	//상세화면
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("nno") Long nno,
							   Model model) {
		
		Notice notice = noticeService.getDetail(nno);
		model.addAttribute("notice", notice); //화면전달
		
		return "notice/noticeDetail";
	}
	//목록
	@GetMapping("/noticeListAll")
	public String noticeListAll(Model model) {
		
		List<Notice> list = noticeService.getList();
		model.addAttribute("list", list);
		
		return "notice/noticeListAll";
	}
	
	//개인목록
	@GetMapping("/noticeListMe")
	public String noticeListMe(HttpSession session,
							   Model model) {
		
		String userId = (String)session.getAttribute("userId");

		List<Notice> list = noticeService.getListMe(userId);
		model.addAttribute("list", list);
		
		
		return "notice/noticeListMe";
	}
	
	//수정화면
	@GetMapping("/noticeModify")
	public String noticeModify(@RequestParam("nno")Long nno,
								@RequestParam("writer")String writer,
								HttpSession session,
								Model model) {
		String userId = (String)session.getAttribute("userId");
		if(userId.equals(writer)==false) {
			return "redirect:/noticeListAll";
		}
		Notice notice = noticeService.getDetail(nno);
		model.addAttribute("notice", notice);
		return "notice/noticeModify";
	}
	
	//등록화면
	@GetMapping("/noticeReg")
	public String noticeReg() {
		return "notice/noticeReg";
	}
	
	//등록폼요청 (엔티티와 VO는 별개)
	@PostMapping("/noticeRegForm")
	public String noticeRegForm(Notice notice) {
		
		Notice n = noticeService.noticeReg(notice);
		if(n == null) {
			System.out.println("등록실패");
		} else {
			System.out.println("등록성공");
		}
		
		
		return "redirect:/notice/noticeListAll"; //목록화면
	}
	//수정폼 요철
	@PostMapping("/noticeUpdate")
	public String noticeUpdate(Notice notice) {
	Notice n = noticeService.noticeUpdate(notice);
	if(n == null) {
		System.out.println("수정실패");
	}else {
		System.out.println("수정성공");
	}
		return "redirect:/notice/notice";
	}
	//삭제요청
	@PostMapping("/noticeDelete")
	public String noticeDelete(@RequestParam("nno") Long nno) {
		
		return "redirect:/notion/noticeListMe";
	}
	
	
	
	
	
	
	
}
