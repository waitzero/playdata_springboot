package com.simple.bootbasic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder //빌더
@ToString //투스트링 오버라이드
@Getter //getter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든멤버변수생성자
@Setter //setter
public class BuilderVO2 {

	private String name;
	private int age;
}
