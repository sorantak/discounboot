package com.codepresso.comtroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.domain.Basket;
import com.codepresso.domain.ResponseVO;
import com.codepresso.service.BasketService;

@RestController
@RequestMapping("/basket")
public class BasketController {

	private static final Logger logger = LoggerFactory.getLogger(BasketController.class);

	@Autowired
	BasketService basketService;

	@PostMapping("")
	public ResponseVO addPRod(@CookieValue(value = "accesstoken", required = false) String accesstoken,
			@RequestParam Long prodNo) throws Exception {
		logger.info("call addProd()");

		Basket basketResult = basketService.addProd(accesstoken, prodNo);
		ResponseVO result = new ResponseVO();
		result.setCode(HttpStatus.OK);
		result.setMessage("SUCCESS");
		result.setData(basketResult);
		return result;
	}

	@DeleteMapping("")
	public ResponseVO removeProd(@CookieValue(value = "accesstoken", required = false) String accesstoken,
			@RequestParam Long prodNo) throws Exception {
		logger.info("call removeProd()");

		Basket basketResult = basketService.removeProd(accesstoken, prodNo);
		ResponseVO result = new ResponseVO();
		result.setCode(HttpStatus.OK);
		result.setMessage("SUCCESS");
		result.setData(basketResult);
		return result;
	}

	@GetMapping("")
	public ResponseVO findAll(@CookieValue(value = "accesstoken", required = false) String accesstoken)
			throws Exception {
		logger.info("call findAll()");

		Basket[] basketResult = basketService.findAll(accesstoken);
		ResponseVO result = new ResponseVO();
		result.setCode(HttpStatus.OK);
		result.setMessage("SUCCESS");
		result.setData(basketResult);
		return result;
	}

}
