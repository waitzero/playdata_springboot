package com.simple.bootbasic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.bootbasic.command.BoardVO;
import com.simple.bootbasic.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	//멤버변수 선언
	@Autowired
	@Qualifier("boardService")
	BoardService boardService;
	
	
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		List<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
	
	@GetMapping("/boardRegister")
	public String boardRegister() {
		return "board/boardRegister";
	}
	
	@GetMapping("/boardResult")
	public String boardResult() {
		return "board/boardResult";
	}
	
	
	@PostMapping("/boardForm")
	public String boardForm(@Valid BoardVO vo, Errors errors, Model model) {
		
		//등록
		if(errors.hasErrors()) {
			for(FieldError err  : errors.getFieldErrors() ) {
				model.addAttribute("valid_" + err.getField() , err.getDefaultMessage());
			}
			
			return "board/boardRegister"; //등록화면
		}

		//서비스 영역으로 진입.
		//
		int result = boardService.regist(vo);
		
		return "redirect:/board/boardResult"; //결과화면
	}
	
	@GetMapping("/getDetail")
	public String getDetail(@RequestParam("bno") int bno,
							Model model) {
		
		//조회
		BoardVO vo = boardService.getDetail(bno);
		model.addAttribute("vo", vo);
		
		return "board/boardDetail"; //상세화면
	}
	
	
	
	
	
	
	
}
