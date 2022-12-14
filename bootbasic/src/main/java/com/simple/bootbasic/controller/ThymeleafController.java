package com.simple.bootbasic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.bootbasic.command.BuilderVO;
import com.simple.bootbasic.command.BuilderVO.Builder;
import com.simple.bootbasic.command.BuilderVO2;
import com.simple.bootbasic.command.SimpleVO;

@Controller
@RequestMapping("/view")
public class ThymeleafController {

	//@RequestMapping(value="/ex01", method = RequestMethod.GET) //get만 허용
	@GetMapping("/ex01")
	public String ex01() {
		
		return "view/ex01"; // 템플릿폴더 하위
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		List<BuilderVO2> list = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			BuilderVO2 vo = BuilderVO2.builder()
									.name("홍길동" + i)
									.age(i)
									.build();
			//리스트에 vo추가
			list.add(vo);
		}
				
		model.addAttribute("list", list); 
		
		return "view/ex02";
	}
	
	//ex03
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		List<SimpleVO> list = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			
			SimpleVO vo = SimpleVO.builder()
									.sno(i)
									.first("홍")
									.last("길동")
									.regdate(LocalDateTime.now() )
									.build();
			list.add(vo);
			
		}
		
		model.addAttribute("list", list);
		
		
		
		
		return "view/ex03";
	}
	
	//a링크 기본방식
	@GetMapping("/ex03_result")
	public String ex03_result(SimpleVO vo) {
		
		System.out.println(vo.toString());
		
		return "view/ex03_result";
	}
	
	//a링크 pathvariable방식
	@GetMapping("/ex03_result2/{a}/{b}")
	public String ex03_result2(@PathVariable("a") int sno,
							   @PathVariable("b") String first) {
		
		System.out.println(sno);
		System.out.println(first);
		
		return "view/ex03_result";
	}
	
	
	
	@GetMapping("/ex04")
	public String ex04(Model model) {
		
		SimpleVO vo = SimpleVO.builder()
				.sno(10)
				.first("홍")
				.last("길동")
				.regdate(LocalDateTime.now() )
				.build();
		
		model.addAttribute("vo", vo);
		model.addAttribute("name", "이순신");
		model.addAttribute("arr", new int[] {1,2,3} );
		
		
		
		return "view/ex04";
	}
	
	
	@GetMapping("/ex05")
	public String ex05(Model model) {
		
		SimpleVO vo = SimpleVO.builder()
				.sno(10)
				.first("홍")
				.last("길동")
				.regdate(LocalDateTime.now() )
				.build();
		
		model.addAttribute("vo", vo);
		model.addAttribute("name", "이순신");
		model.addAttribute("arr",  Arrays.asList(1,2,3)  ); //리스트
		
		
		return "view/ex05";
	}
	
	
	@GetMapping("/ex06")
	public String ex06() {
		return "view/ex06";
	}
	
	
	@GetMapping({"/ex07", "/ex08" })
	public void ex07() {
	}
	
	
	/////////////////////////////////
	//1. 화면띄우기~
	//2. 데이터 보내기~
	//3. 화면에 출력~
	
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
		
		//벽보고 반성
		List<SimpleVO> list = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			SimpleVO vo = SimpleVO.builder()
									.sno(i)
									.first("홍")
									.last("길동")
									.regdate(LocalDateTime.now() )
									.build();
			list.add(vo);
		}
		
		model.addAttribute("list", list);
		
		
		return "view/quiz01";
	}
	
	
	@GetMapping("/quiz02")
	public String quiz02(Model model) {
		
		SimpleVO vo = SimpleVO.builder()
					.first("홍")
					.last("길동")
					.sno(10)
					.regdate(LocalDateTime.now())
					.build();
			
		model.addAttribute("vo", vo);
		
		
		return "view/quiz02";
	}
	
	
	@GetMapping("/quiz02_result")
	public String result(@ModelAttribute("sno") int sno,
						 @ModelAttribute("name") String name) { //request + model
							
		System.out.println(sno);
		System.out.println(name);
		
		return "view/quiz02_result";
	}
	
	
	
	
	
	
	
	
	
	
	
}
