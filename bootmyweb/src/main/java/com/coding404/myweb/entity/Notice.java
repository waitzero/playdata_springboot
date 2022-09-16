package com.coding404.myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "NOTICE")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long nno; //PK
	
	@Column(length = 20)
	private String noticedate;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	@Column(length = 300, nullable =  false)
	private String title;
	
//	@Column(columnDefinition = "~~~~~")
	@Column(length = 2000)
	private String content;
	
	
	
}
