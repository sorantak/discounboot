package com.codepresso.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codepresso.domain.Basket;
import com.codepresso.domain.Prod;
import com.codepresso.domain.Token;
import com.codepresso.persistence.BasketRepository;
import com.codepresso.persistence.ProdRepository;
import com.codepresso.persistence.TokenRepository;

@Service
public class BasketService {

	private static final Logger logger = LoggerFactory.getLogger(BasketService.class);

	@Autowired
	TokenRepository tokenRepo;

	@Autowired
	BasketRepository basketRepo;

	@Autowired
	ProdRepository prodRepo;

	public Basket addProd(String accesstoken, Long prodNo) {
		logger.info("call addProd()");

		Token token = tokenRepo.findByToken(accesstoken);
		String userEmail = token.getUserEmail();

		Basket basket = new Basket();
		basket.setUserEmail(userEmail);
		basket.setProdNo(prodNo);

		basketRepo.save(basket);
		Basket result = basketRepo.findByUserEmailAndProdNo(userEmail, prodNo);

		Prod prod = prodRepo.findByNo(prodNo);
		prod.setInBasket(true);
		result.setProd(prod);

		return result;
	}

	public Basket removeProd(String accesstoken, Long prodNo) {
		logger.info("call removeProd()");

		Token token = tokenRepo.findByToken(accesstoken);
		String userEmail = token.getUserEmail();

		Basket basket = new Basket();
		basket.setUserEmail(userEmail);
		basket.setProdNo(prodNo);
		basketRepo.deleteAllByUserEmailAndProdNo(userEmail, prodNo);

		return null;
	}

	public Basket[] findAll(String accesstoken) {
		logger.info("call findAll()");
		Token token = tokenRepo.findByToken(accesstoken);
		String userEmail = token.getUserEmail();

		List<Basket> basket = basketRepo.findAllByUserEmail(userEmail);
		Basket[] basketList = new Basket[basket.size()];
		for (int i = 0; i < basketList.length; i++) {
			Basket basketInfo = new Basket();

			Long no = basket.get(i).getProdNo();
			Prod prodInfo = new Prod();
			prodInfo = prodRepo.findByNo(no);
			prodInfo.setInBasket(true);
			basketInfo.setProd(prodInfo);

			basketInfo.setUserEmail(userEmail);
			LocalDateTime createdAt = basket.get(i).getCreatedAt();
			basketInfo.setCreatedAt(createdAt);
			Long id = basket.get(i).getId();
			basketInfo.setId(id);
			Long prodNo = basket.get(i).getProdNo();
			basketInfo.setProdNo(prodNo);

			basketList[i] = basketInfo;
		}
		return basketList;
	}

}
