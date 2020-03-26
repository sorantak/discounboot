package com.codepresso.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "basket")
@Entity
public class Basket {

	@Id
	@GeneratedValue
	private Long id;
	private String userEmail;
	private Long prodNo;
	private LocalDateTime createdAt;
//	@Transient
//	private Prod prod;

	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

//	@ManyToOne
//	@JoinColumn(name = "prod_no", nullable = false, updatable = false)
//	@JsonIgnore
//	private Prod prod;
//
//	public void setProd(Prod prod) {
//		if (this.prod != null) {
//			this.prod.getBasketList().add(this);
//		}
//		this.prod = prod;
//		prod.getBasketList().add(this);
//	}
	
//	@Transient
//	@ManyToOne
//	@JoinColumn(name = "prod_no", nullable = false, updatable = false)
//	@JsonIgnore
//	private User user;
//
//	public void setUser(User user) {
//		if (this.user != null) {
//			this.user.getBasketList().add(this);
//		}
//		this.user = user;
//		user.getBasketList().add(this);
//	}
	
}
