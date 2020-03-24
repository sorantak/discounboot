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
public class Prod {

	@Id
	@GeneratedValue
	private Long no;
	private String name;
	private String thumbnailUrl;
	private Long originPrice;
	private Long discPrice;
	private String description;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;
	@Transient
	private boolean inBasket;

}
