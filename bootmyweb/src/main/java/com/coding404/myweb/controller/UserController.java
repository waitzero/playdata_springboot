package com.coding404.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.UsersVO;
import com.coding404.myweb.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//로그인화면
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	//가입화면
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	//상세화면
	@GetMapping("/userDetail")
	public String userDetail() {
		return "user/userDetail";
	}

	//회원가입
	@PostMapping("/joinForm")
	public String joinForm(UsersVO vo, RedirectAttributes RA) {
		
		int result = userService.join(vo);
		
		if(result == 1) { //성공
			RA.addFlashAttribute("msg", "환영합니다");
		} else { //실패
			RA.addFlashAttribute("msg", "가입에 실패했습니다. 관리자에게 문의하세요");
		}
		
		return "redirect:/user/login"; //이동
		
	}
	
	@PostMapping("/login")
	public String login(UsersVO vo, RedirectAttributes RA, HttpSession session) {
		
		//로그인처리
		UsersVO userVO = userService.login(vo);
		if(userVO != null) { //로그인 성공
			
			//성공이었다면 세션에 정보를 저장한다.
			//화면에서 세션에 대한 접근 [[${session.userName}]] 
			session.setAttribute("userId", userVO.getId());
			session.setAttribute("userName", userVO.getName());
			
			//홈화면으로 이동.
			return "redirect:/main"; //성공시 메인화면
		} else { //로그인 실패
			//다시 로그인 화면
			RA.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			return "redirect:/user/login";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
