package com.simple.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //JPA의 엔티티로 관리
@Table(name = "TBL_MEMO") //테이블명 지정
@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

	//JPA사용시에는 기본타입을 사용하지 않고 wrapper타입을 사용합니다.
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long mno; 
	
	@Column(length = 300, nullable = false) // 길이와 not null
	private String writer;
	
	@Column(columnDefinition = "varchar(300) default 'admin' ") //직접 컬럼모형을 지정
	private String text;
	
	@Transient //VO에 사용은하지만, 컬럼으로 지정하지 않을 값
	private String hello; 
	
	
	
	
	
	
}
