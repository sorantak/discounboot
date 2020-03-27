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

		Token token = tokenRepo.findByToken(accesstoken);
		logger.info("token: " + token);
		Long userId = token.getUser().getId();
		logger.info("usreId: " + userId);
		
		Basket basket = new Basket();
		logger.info("basket1 : " + basket);
		basket.getUser().setId(userId);
		logger.info("basket2 : " + basket);

		basket.getProd().setId(prodId);
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
