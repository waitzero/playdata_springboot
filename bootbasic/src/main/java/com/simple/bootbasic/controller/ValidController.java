package com.simple.bootbasic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.bootbasic.command.MemberVO;
import com.simple.bootbasic.command.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {

	//화면처리
	@GetMapping("/view")
	public String view() {
		return "valid/view";
	}
	
	//폼처리
	@PostMapping("/validForm")
	public String validForm(@Valid ValidVO vo, Errors errors, Model model ) {
		//@Valid가 붙은 유효성검사를 진행, 유효성 검사에 실패한 멤버변수는 errors바인딩
		
		if(errors.hasErrors()) {
			//System.out.println("유효성검사 실패");
			//System.out.println("유효성검사 실패개수:" + errors.getFieldErrorCount());
			
			List<FieldError> list = errors.getFieldErrors(); //유효성 검사 실패 목록
			for(FieldError err  : list ) {
				//System.out.println(err);
				//System.out.println(err.getField() ); //유효성에 실패한 필드명
				//System.out.println(err.getDefaultMessage() ); //유효성에 실패한 필드 메시지
				
				if(err.isBindingFailure() == true) { //유효성검사에 매칭안됨
					model.addAttribute("valid_" + err.getField() , "요청 형식을 일치시키세요");
				} else { //유효성검사 매칭됨
					model.addAttribute("valid_" + err.getField() , err.getDefaultMessage());
				}
				
			}
			
			//데이터를 화면에 유지하기 위해서 vo를 model에 저장
			model.addAttribute("vo", vo);
			
			//원래 페이지로 보낼거야
			return "valid/view";
		}
		
		
		System.out.println(vo.toString());
			
		
		return "valid/view_success";
	}
	
	
	/////////////////////////////////////////////////////////
	//화면요청
	@GetMapping("/quiz01")
	public String quiz01() {
		
		return "valid/quiz01";
	}
	
	@PostMapping("/quizForm")
	public String quizForm(@Valid MemberVO vo, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			for(FieldError err : list ) {
				model.addAttribute("valid_" + err.getField(), err.getDefaultMessage() );
			}
			
			model.addAttribute("vo", vo);
			return "valid/quiz01"; //원래화면으로
		}
		
		
		System.out.println(vo.toString());
		
		return "valid/quiz01_result";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
