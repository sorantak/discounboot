package com.codepresso.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.Basket;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {

	public Basket findByUserEmailAndProdNo(String userEmail, Long prodNo);

	// https://yoonho-devlog.tistory.com/61
	@Transactional
	public void deleteAllByUserEmailAndProdNo(String userEmail, Long prodNo);

	public List<Basket> findAllByUserEmail(String userEmail);

	public Basket findByUserEmail(String email);

}
