package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
public class Prod {

	@Id
	@GeneratedValue
	@Column(name = "no")
	private Long no;
	private String name;
	private String thumbnailUrl;
	private Long originPrice;
	private Long discPrice;
	private String description;
	private LocalDateTime createdAt;
	@Transient
	private boolean inBasket;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

}
