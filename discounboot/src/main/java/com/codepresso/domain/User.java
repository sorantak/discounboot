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
public class User {

	@Id @GeneratedValue
	private String email;
	private String name;
	private String birth;
	private String password;
	@Transient
	private String passwordCheck;
	private String gender;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;

}
