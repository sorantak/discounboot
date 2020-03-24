package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
@Entity
public class ProdDetail {

	@Id
	private Long id;
	@Column(name = "prod_no")
	private Long prodNo;
	private String content;
	private String imageUrl;
	private LocalDateTime createdAt;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

	@Transient
	@ManyToOne
	@JoinColumn(name = "prod_no", nullable = false, insertable = false, updatable = false)
	private Prod prod;

}
