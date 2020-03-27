package com.codepresso.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
/*
		Token token = tokenRepo.findByToken(accesstoken);
		Long userId = token.getUser().getId();
		
//		Basket basket = basketRepo.saveOne(userId, prodId);
//		Basket basket = new Basket();
//		User user = userRepo.findById(userId);
//		basket.setUser(user);
//		Optional<Prod> prod = prodRepo.findById(prodId);
//		Prod prod2 = new Prod();
//		Long prodId1 = prod.get().getId();
//		prod2.setId(prodId1);
//		String name = prod.get().getName();
//		prod2.setName(name);
//		String tUrl = prod.get().getThumbnailUrl();
//		prod2.setThumbnailUrl(tUrl);
//		Long oPrice = prod.get().getOriginPrice();
//		prod2.setOriginPrice(oPrice);
//		Long dPrice = prod.get().getDiscPrice();
//		prod2.setDiscPrice(dPrice);
//		LocalDateTime createdAt = prod.get().getCreatedAt();
//		prod2.setCreatedAt(createdAt);
//		basket.setProd(prod2);

//		basketRepo.save(basket);
		Basket result = basketRepo.findByUserIdAndProdId(userId, prodId);
		result.getProd().setInBasket(true);*/

		return null;
	}

	public Basket removeProd(String accesstoken, Long prodId) {
		logger.info("call removeProd()");

		Token token = tokenRepo.findByToken(accesstoken);
		Long userId = token.getUser().getId();

		Basket basket = new Basket();
		basket.getUser().setId(userId);
		basket.getProd().setId(prodId);
		basketRepo.deleteOneByUserIdAndProdId(userId, prodId);

		return null;
	}

	public List<Basket> findAll(String accesstoken) {
		logger.info("call findAll()");
		Token token = tokenRepo.findByToken(accesstoken);
		Long userId = token.getUser().getId();

		List<Basket> basket = basketRepo.findAllByuserId(userId);
/*		Basket[] basketList = new Basket[basket.size()];
		for (int i = 0; i < basketList.length; i++) {
			Basket basketInfo = new Basket();

			Long no = basket.get(i).getProd().getId();
			Optional<Prod> prodInfo = prodRepo.findById(no);
			prodInfo.get().setInBasket(true);
			basketInfo.setProd(prodInfo);

			basketInfo.setUserEmail(userId);
			LocalDateTime createdAt = basket.get(i).getCreatedAt();
			basketInfo.setCreatedAt(createdAt);
			Long id = basket.get(i).getId();
			basketInfo.setId(id);
			Long prodNo = basket.get(i).getProdNo();
			basketInfo.setProdNo(prodNo);

			basketList[i] = basketInfo;
		}*/
		return basket;
	}

}
