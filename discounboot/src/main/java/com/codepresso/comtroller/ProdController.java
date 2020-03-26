package com.codepresso.comtroller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.domain.Prod;
import com.codepresso.domain.ResponseVO;
import com.codepresso.service.ProdService;

@RestController
@RequestMapping("/prod")
public class ProdController {

	private static final Logger logger = LoggerFactory.getLogger(ProdController.class);

	@Autowired
	ProdService prodService;

	@GetMapping("/page")
	public ResponseVO findSix(@CookieValue(value = "accesstoken", required = false) String accesstoken)
			throws Exception {
		logger.info("call findSix()");

		List<Prod> prodResult = prodService.findSix(accesstoken);
		ResponseVO result = new ResponseVO();
		result.setCode(HttpStatus.OK);
		result.setMessage("SUCCESS");
		result.setData(prodResult);
		return result;
	}

	@GetMapping("/{id}")
	public ResponseVO findProdWithDetailByUser(@CookieValue(value = "accesstoken", required = false) String accesstoken,
			@PathVariable("id") Long id) throws Exception {
		logger.info("call findProdWithDetailByUser()");
		
		Optional<Prod> prodResult = prodService.findProdWithDetailByUser(accesstoken, id);
		ResponseVO result = new ResponseVO();
		result.setCode(HttpStatus.OK);
		result.setMessage("SUCCESS");
		result.setData(prodResult);
		return result;
	}	
}
