package com.codepresso.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "basketList")
@Table(name = "user")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
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

	@Transient
	@OneToOne(mappedBy = "user")
	private Token token;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Basket> basketList = new ArrayList<Basket>();
	
}
