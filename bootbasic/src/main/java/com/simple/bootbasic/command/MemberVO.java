package com.simple.bootbasic.command;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	@Pattern(regexp = "[a-zA-Z0-9]{8,}", message = "아이디는 영문자 숫자 8자 이상")
	private String id;
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호 특수문자 포함 8자 이상")
	private String pw;
}
