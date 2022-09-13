package com.simple.bootbasic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleVO {

	private int sno; //정수
	private String first;
	private String last; //문자열
	private LocalDateTime regdate; //시간
}
