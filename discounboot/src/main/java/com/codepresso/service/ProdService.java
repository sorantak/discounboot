package com.codepresso.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codepresso.domain.Basket;
import com.codepresso.domain.Prod;
import com.codepresso.domain.ProdDetail;
import com.codepresso.domain.Token;
import com.codepresso.persistence.BasketRepository;
import com.codepresso.persistence.ProdDetailRepository;
import com.codepresso.persistence.ProdRepository;
import com.codepresso.persistence.TokenRepository;

@Service
public class ProdService {

	private static final Logger logger = LoggerFactory.getLogger(ProdService.class);

	@Autowired
	TokenRepository tokenRepo;

	@Autowired
	ProdRepository prodRepo;

	@Autowired
	BasketRepository basketRepo;

	@Autowired
	ProdDetailRepository detailRepo;

	public List<Prod> findSix(String accesstoken) {
		logger.info("call findSix()");

		Pageable paging = PageRequest.of(0, 6, Sort.Direction.ASC, "id");
		List<Prod> prodResult = prodRepo.findAll(paging);

		if (accesstoken != null) {
			Token token = tokenRepo.findByToken(accesstoken);
			Long userId = token.getUser().getId();
			for (int i = 0; i < prodResult.size(); i++) {
				Long prodId = prodResult.get(i).getId();
				Basket basket = basketRepo.findByUserIdAndProdId(userId, prodId);
				if (basket != null) {
					boolean inBasket = true;
					prodResult.get(i).setInBasket(inBasket);
					return prodResult;
				}
				return prodResult;
			}
		}
		return prodResult;
	}

	public Optional<Prod> findProdWithDetailByUser(String accesstoken, Long id) {
		logger.info("call findProdWithDetailByUser()");

		Optional<Prod> prodResult = prodRepo.findById(id);
		
		// token 있을 시 문제 발생, 없으면 정상 작동
		logger.info("accesstoken: " + accesstoken);
		if (accesstoken != null) {
			Token token = tokenRepo.findByToken(accesstoken);
			logger.info("token: " + token);
			Long userId = token.getUser().getId();
			Basket basket = basketRepo.findByUserIdAndProdId(userId, id);
			if (basket != null) {
				List<ProdDetail> detailInfo = detailRepo.findByProdId(id);
				prodResult.get().setDetailList(detailInfo);
				boolean inBasket = true;
				prodResult.get().setInBasket(inBasket);
				return prodResult;
			}
			List<ProdDetail> detailInfo = detailRepo.findByProdId(id);
			prodResult.get().setDetailList(detailInfo);
			return prodResult;

		}
		List<ProdDetail> detailInfo = detailRepo.findByProdId(id);
		prodResult.get().setDetailList(detailInfo);
		return prodResult;
	}

}
