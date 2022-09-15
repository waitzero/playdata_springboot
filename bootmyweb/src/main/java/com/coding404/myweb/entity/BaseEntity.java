package com.coding404.myweb.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Getter;

@MappedSuperclass //부모클래스의 용도로 사용
@EntityListeners(AuditingEntityListener.class) //엔티티를 관리하는 영속영역에서 자동으로 변화를 감지해서 변수에 적용해라
@Getter
public class BaseEntity {
	//각각 엔티티들이 공통으로 사용할 클래스
	@CreatedDate //생성시간
	@Column(updatable = false) //자동 업데이트를 사용하지 않음
	private LocalDateTime regdate;
	
	@LastModifiedDate //변경시간
	@Column
	private LocalDateTime moddate;
	
	//BootmywebApplication클래스에 @EnableJpaAuditing를 반드시 붙인다.
	
}
