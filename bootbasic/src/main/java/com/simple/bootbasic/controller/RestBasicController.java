package com.simple.bootbasic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.bootbasic.command.BoardVO;
import com.simple.bootbasic.command.SimpleVO;

@RestController //완전히 다른 방식으로 컨트롤러 역할
public class RestBasicController {

	
	//@ResponseBody //생략...
	//consumer : 반드시 이 타입으로 데이터를 보내라
	//producer : 제공되는 데이터 타입은 이 타입으로 보낼게 (default: json)
	@GetMapping(value = "/text" /*, produces = "text/plain"*/)
	public String text() {
		
		return "hello world"; //??
	}
	
	//객체를 반환하는 모형
	//Jackson-databind 모듈이 자동으로 형변환을 시켜서 반환
	//보내는 형식의 데이터 json
	@GetMapping(value = "/getObject", produces = "application/json")
	public SimpleVO getObject() {
		
		SimpleVO vo = new SimpleVO(10, "홍", "길동", LocalDateTime.now());
		
		return vo;
	}
	
	//맵타입의 반환
	@GetMapping("/getObject2")
	public Map<String, Object> getObject2() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("data", new SimpleVO(10, "홍", "길동", LocalDateTime.now()) );
		
		return map;
	}
	
	//리스트타입의 반환
	@GetMapping("/getObject3")
	public List<SimpleVO> getObject3() {
		
		List<SimpleVO> list = new ArrayList<>();
		list.add( new SimpleVO(1, "홍", "길동", LocalDateTime.now()) );
		list.add( new SimpleVO(2, "이", "순신", LocalDateTime.now()) );

		return list;
	}
	
	////////////////get방식으로 데이터를 받는 방법///////////////
	//http://localhost:8181/getData?key=홍길동&bno=1
	@CrossOrigin("*") //외부요청에 대하여 허용함 (서버가 다른경우 요청을 허용할떄 사용)
	@GetMapping("/getData")
	public SimpleVO getData(@RequestParam("key") String key,
							@RequestParam("bno") int bno) {
		
		System.out.println("받은데이터:");
		System.out.println(key);
		System.out.println(bno);
		
		return  new SimpleVO(1, "홍", "길동", LocalDateTime.now());
	}
	
	
	//http://localhost:8181/getData2/홍길동/1
	@GetMapping("/getData2/{key}/{bno}")
	public SimpleVO getData2(@PathVariable("key") String key,
							 @PathVariable("bno") String bno) {
		
		System.out.println("받은데이터:");
		System.out.println(key);
		System.out.println(bno);
		
		return new SimpleVO(1, "이", "순신", LocalDateTime.now());
	}
	
	
	////////////////////////post방식/////////////////////////////
	//Cross-Origin Resource Sharing - cors
	//제약 - 같은서버에서는 제약이 x, 서버가 다른경우 기본적으로 거절
	
	//제이슨 데이터를 화면에서 보낼떄는 키와 값을 "" 반드시 묶어서 보내야 합니다.
	//VO에 제이슨 데이터를 맵핑할때 @RequestBody로 받는다
	@CrossOrigin("*")
	@PostMapping("/getJSON")
	public List<SimpleVO> getJSON(@RequestBody SimpleVO vo ) {
		
		System.out.println(vo.toString());
		
		//반환값
		List<SimpleVO> list = new ArrayList<>();
		list.add( new SimpleVO(1, "홍", "길동", LocalDateTime.now()) );
		list.add( new SimpleVO(2, "이", "순신", LocalDateTime.now()) );

		return list;
	}
	
	//map을 이용해서 데이터 받기
	@PostMapping("/getJSON2")
	public SimpleVO getJSON2(@RequestBody Map<String, Object> map ) {
		
		System.out.println(map.toString());
		
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}
	
	//consumers를 사용해서 데이터를 제한 (반드시 text로 보내라)
	//보내는 측에서 Content-type을 text로 지정하고 보내야 합니다.
	@PostMapping(value = "/getText", consumes = "text/plain")
	public SimpleVO getText(@RequestBody String data ) {
		
		System.out.println(data);
		
		
		return new SimpleVO(2, "이", "순신", LocalDateTime.now());
	}
	
	
	////////////////////////////////////////////////////////
	//간단한 실습
	//요청경로 test
	//요청방식 post
	//화면에서 보내는 데이터의 JSON형식의 키값 - bno, name, title
	//{"bno":1, "name": "안녕", "title": "하시오?" }
	//서버에서 반환하는 데이터는 map형식(자유) 
	
	@PostMapping("/test")
	public Map<String ,Object> test(@RequestBody BoardVO vo ) {
		//값을 받음
		System.out.println(vo.toString());
		
		//데이터베이스에서 등록 or 조회
				
		//값을 보냄
		Map<String, Object> map = new HashMap<>();
		map.put("1", "홍길동");
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
}
