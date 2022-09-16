package com.coding404.myweb.util.page;

import lombok.Data;

@Data
public class Criteria {

	private int page; //조회하는 페이지번호
	private int amount; //조회하는 데이터개수
	
	//검색키워드
	private String writer;
	private String title;
	private String content;
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	
	
	
	
	
}
