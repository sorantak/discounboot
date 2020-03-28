package com.codepresso.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codepresso.domain.Basket;
import com.codepresso.domain.Prod;
import com.codepresso.domain.Token;
import com.codepresso.domain.User;
import com.codepresso.persistence.BasketRepository;
import com.codepresso.persistence.ProdRepository;
import com.codepresso.persistence.TokenRepository;
import com.codepresso.persistence.UserRepository;

@Transactional
@Service
public class BasketService {

	private static final Logger logger = LoggerFactory.getLogger(BasketService.class);

	@Autowired
	TokenRepository tokenRepo;

	@Autowired
	BasketRepository basketRepo;

	@Autowired
	ProdRepository prodRepo;

	@Autowired
	UserRepository userRepo;

	public Basket addProd(String accesstoken, Long prodId) {
		logger.info("call addProd()");

		Token token = tokenRepo.findByToken(accesstoken);
		Long userId = token.getUser().getId();

		Basket basket = new Basket();

		User user = userRepo.findOneById(userId);
		basket.setUser(user);

		Prod prod = prodRepo.findOneById(prodId);
		basket.setProd(prod);

		basketRepo.save(basket);
		Basket result = basketRepo.findByUserIdAndProdId(userId, prodId);
		result.getProd().setInBasket(true);
		return result;
	}

	public Basket removeProd(String accesstoken, Long prodId) {
		logger.info("call removeProd()");

		Token token = tokenRepo.findByToken(accesstoken);
		Long userId = token.getUser().getId();

		Basket basket = new Basket();
		User user = userRepo.findOneById(userId);
		basket.setUser(user);

		Prod prod = prodRepo.findOneById(prodId);
		basket.setProd(prod);
		basketRepo.deleteOneByUserIdAndProdId(userId, prodId);

		return null;
	}

	public List<Basket> findAll(String accesstoken) {
		logger.info("call findAll()");
		Token token = tokenRepo.findByToken(accesstoken);
		Long userId = token.getUser().getId();

		List<Basket> basket = basketRepo.findAllByuserId(userId);
		basket.get(0).getProd().setInBasket(true);

		return basket;
	}

}
