package com.codepresso;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codepresso.domain.Prod;
import com.codepresso.domain.ProdDetail;
import com.codepresso.persistence.ProdDetailRepository;
import com.codepresso.persistence.ProdRepository;
import com.codepresso.persistence.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DiscounbootApplicationTests {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProdDetailRepository detailRepo;
	@Autowired
	private ProdRepository prodRepo;
	
//	@Test
//	public void testFindByEmail() {
//		int userList = userRepo.countByEmail("user01@gmail.com");
//		
//		System.out.println("검색 결과");
//		System.out.println("---> " + userList);
//	}
	
//	@Test
//	public void test1() {
//		Prod prod = prodRepo.findByNo(1L);
//		System.out.println(prod.toString());
//		System.out.println(prod.getDetailList().size());
//		
//	}
	/*
	@Test
	public void test(Long prodNo) {
		Long i = (long) 1;
		List<ProdDetail> detailList = detailRepo.findAllByProdNo(i);
		System.out.println("검색결과");
		for (ProdDetail detail : detailList) {
			System.out.println("짠: " + detail.toString());
		}
	}*/
}
