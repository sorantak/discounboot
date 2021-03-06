package com.codepresso.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.Basket;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {

	public Basket findByUserIdAndProdId(Long userId, Long prodId);

	// https://yoonho-devlog.tistory.com/61
	// 숙제, repository 에 붙이는 것이 맞는 것인가: Service에 붙임
//	@Transactional
	public void deleteOneByUserIdAndProdId(Long userId, Long prodId);

	public List<Basket> findAllByuserId(Long userId);

	public Basket findByuserId(Long userId);

}
