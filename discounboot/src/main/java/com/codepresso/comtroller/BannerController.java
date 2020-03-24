package com.codepresso.comtroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.domain.Banner;
import com.codepresso.domain.ResponseVO;
import com.codepresso.service.BannerService;

@RestController
@RequestMapping("/banner")
public class BannerController {

	private static final Logger logger = LoggerFactory.getLogger(BannerController.class);
	
	@Autowired
	BannerService bannerService;
	
	@GetMapping("")
	public ResponseVO findAll() throws Exception{
		logger.info("call findAll()");
		
		List<Banner> bannerResult = bannerService.findAll();
		ResponseVO result = new ResponseVO();
		result.setCode(HttpStatus.OK);
		result.setMessage("SUCCESS");
		result.setData(bannerResult);
		return result;
	}
	
}
