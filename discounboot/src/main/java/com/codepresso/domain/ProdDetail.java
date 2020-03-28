package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString(exclude = "prod")
@Table(name = "prod_detail")
@Entity
public class ProdDetail {

	@Id
	@GeneratedValue
	private Long id;
	private String content;
	private String imageUrl;
	private LocalDateTime createdAt;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

	@ManyToOne
	@JoinColumn(name = "prod_id", nullable = false)
	@JsonIgnore
	private Prod prod;

	public void setProd(Prod prod) {
		if (this.prod != null) {
			this.prod.getDetailList().add(this);
		}
		this.prod = prod;
		prod.getDetailList().add(this);
	}

}
