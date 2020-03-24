package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Banner {

	@Id
	@GeneratedValue
	private Long id;
	private String content;
	private LocalDateTime createdAt;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

}
