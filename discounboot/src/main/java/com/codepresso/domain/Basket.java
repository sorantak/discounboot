package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Basket {

	@Id @GeneratedValue
	private Long id;
	private String userEmail;
	private Long prodNo;
	private LocalDateTime createdAt;
	// 연관관계로 추후 수정
	@Transient
	private Prod prod;
	
	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

}
