package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "user")
@Table(name = "token")
@Entity
public class Token {
	
	@Id
	@GeneratedValue
	private Long id;
	private String token;
	private LocalDateTime createdAt;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
