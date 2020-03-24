package com.codepresso;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codepresso.domain.User;
import com.codepresso.persistence.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DiscounbootApplicationTests {

	@Autowired
	private UserRepository userRepo;
	
/*	@Test
	public void testFindByEmail() {
		List<User> userList = userRepo.findByEmail("user01@gmail.com");
		
		System.out.println("검색 결과");
		for (User user : userList) {
			System.out.println("---> " + user.toString());
		}
	}*/
}
