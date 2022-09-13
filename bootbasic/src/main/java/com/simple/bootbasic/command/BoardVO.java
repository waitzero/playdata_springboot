package com.simple.bootbasic.command;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private Integer bno;
	@NotBlank(message = "작성자는 필수")
	private String name;
	@NotBlank(message = "제목은 필수")
	private String title;
	private String content;
	
}
