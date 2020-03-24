package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@ToString(exclude = "token")
@Entity
public class User {

	@Id
	private String email;
	private String name;
	private String birth;
	private String password;
	@Transient
	private String passwordCheck;
	private String gender;
	private LocalDateTime createdAt;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

	/*
	 * @OneToOne(mappedBy = "user") private Token token;
	 */
}
