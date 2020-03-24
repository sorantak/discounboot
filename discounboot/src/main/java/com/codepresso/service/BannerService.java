package com.codepresso.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codepresso.domain.Banner;
import com.codepresso.persistence.BannerRepository;

@Service
public class BannerService {

	private static final Logger logger = LoggerFactory.getLogger(BannerService.class);

	@Autowired
	BannerRepository bannerRepo;

	public List<Banner> findFive() {
		logger.info("call findFive()");

		Pageable paging = PageRequest.of(0, 5, Sort.Direction.ASC, "id");
		List<Banner> bannerList = bannerRepo.findAll(paging);

		return bannerList;
	}

}
