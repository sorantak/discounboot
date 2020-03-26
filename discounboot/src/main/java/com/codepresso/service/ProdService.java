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
	ProdDetailRepository detailRepo;

	@Autowired
	ProdRepository prodRepo;

	@Autowired
	BasketRepository basketRepo;

	public List<Prod> findSix(String accesstoken) {
		logger.info("call findSix()");

		Pageable paging = PageRequest.of(0, 6, Sort.Direction.ASC, "no");
		List<Prod> prodList = prodRepo.findAll(paging);

		for (int i = 0; i < prodList.size(); i++) {
			Token token = tokenRepo.findByToken(accesstoken);
			String email = token.getUserEmail();
			Long prodNo = prodList.get(i).getNo();
			Basket basket = basketRepo.findByUserEmailAndProdNo(email, prodNo);
			if (basket != null) {
				prodList.get(i).setInBasket(true);
			} else {
				prodList.get(i).setInBasket(false);
			}
		}
		return prodList;
	}

	/*
	 * public List<ProdDetail> findProdWithDetailByUser(String accesstoken, Long no)
	 * { logger.info("call findProdWithDetailByUser()");
	 * 
	 * // 이 메서드만으로도 join이 실행되도록 List<ProdDetail> detailList =
	 * detailRepo.findAllByProdNo(no);
	 * 
	 * if (accesstoken != null) { boolean inBasket = true; // Prod prod =
	 * prodRepo.findByNo(no); Prod prod = detailList.get(0).getProd();
	 * prod.setInBasket(inBasket);
	 * 
	 * for (int i = 0; i < detailList.size(); i++) {
	 * detailList.get(i).setProd(prod); } return detailList; } else { return
	 * detailList; } }
	 */

	public Optional<Prod> findProdWithDetailByUser(String accesstoken, Long id) {
		logger.info("call findProdWithDetailByUser()");

		Optional<Prod> prodResult = prodRepo.findById(id);
		// select문 두 개가 아닌 join문 하나가 실행되도록 처리 필요
		// inBasket 처리 필요
		return prodResult;
	}

}
