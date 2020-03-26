package com.codepresso.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "prod")
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

	@OneToMany(mappedBy = "prod", fetch = FetchType.EAGER)
	private List<ProdDetail> detailList = new ArrayList<ProdDetail>();
	
//	@OneToMany(mappedBy = "prod", fetch = FetchType.LAZY)
//	private List<Basket> basketList = new ArrayList<Basket>();
	
}
