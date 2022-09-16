package com.coding404.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding404.myweb.entity.Notice;
import com.coding404.myweb.notice.service.NoticeService;
import com.coding404.myweb.util.page.Criteria;
import com.coding404.myweb.util.page.PageDTO;

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
	public String noticeListAll(@ModelAttribute("cri") Criteria cri, Model model) {
		
		//모든데이터조회
		//List<Notice> list = noticeService.getList();
		//model.addAttribute("list", list);
		
		//페이징
		//PageDTO<Notice> pageDTO = noticeService.getList(cri);
		//model.addAttribute("pageDTO", pageDTO);
		
		//페이지검색
		PageDTO<Notice> pageDTO = noticeService.getList(cri);
		model.addAttribute("pageDTO", pageDTO);
		
		//사용자클래스를 이용해서 메서드 매개변수에 선언하면 클래스명(소문자) 형태로 모델변수에 담아서 가지고 나가게 됩니다.
		//명시적으로 사용 -> @ModelAttribute("이름") Criteria cri
		
		
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
	public String noticeModify(@RequestParam("nno") Long nno,
							   @RequestParam("writer") String writer,
							   HttpSession session,
							   Model model ) {
		
		//화면에서는 nno값과 writer정보를 넘겨줍니다.
		//세션에 저장된 아이디와 화면에서 작성자 정보가 같으면 수정
		String userId = (String)session.getAttribute("userId");
		
		if(userId.equals(writer) == false) {
			return "redirect:/notice/noticeListAll"; //작성자와 로그인된 정보가 같지 않으면 수정불가
		}
		
		//재활용
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
	
	//수정폼요청
	@PostMapping("/noticeUpdate")
	public String noticeUpdate(Notice notice) {
		
		Notice n = noticeService.noticeUpdate(notice);
		if(n == null) {
			System.out.println("수정실패");
		} else {
			System.out.println("수정성공");
		}
		
		return "redirect:/notice/noticeListMe";
	}
	
	//삭제요청
	@PostMapping("/noticeDelete")
	public String noticeDelete(@RequestParam("nno") Long nno) {
		
		noticeService.noticeDelete(nno);
		
		return "redirect:/notice/noticeListMe";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
