package com.codepresso.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	private String userEmail;
	private Long prodNo;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;
	// 연관관계로 추후 수정
	@Transient
	private Prod prod;
}
