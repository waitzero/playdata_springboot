package com.coding404.myweb.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersVO {

	private String id;
	private String name;
	private String pw;
	private String phone;
	private String sns_yn;
	private LocalDateTime regdate; //시간
}
