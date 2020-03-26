package com.codepresso.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
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
@ToString
@Table(name = "prod_detail")
@Entity
public class ProdDetail {

	@Id
	private Long id;
//	@Column(name = "prod_no")
//	private Long prodNo;
	private String content;
	private String imageUrl;
	private LocalDateTime createdAt;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

	@ManyToOne
	@JoinColumn(name = "prod_no", nullable = false, updatable = false)
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
