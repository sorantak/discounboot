package com.codepresso.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codepresso.domain.Token;
import com.codepresso.domain.User;
import com.codepresso.persistence.TokenRepository;
import com.codepresso.persistence.UserRepository;
import com.codepresso.util.RandomToken;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TokenRepository tokenRepo;
	
/*	public List<User> findByEmail(String email) {
		logger.info("call findByEmail()");
		
		return userRepo.findByEmail(email);
	}*/
	
	public int checkEmail(User user) {
		logger.info("call checkEmail()");
		
		String email = user.getEmail();
		int emailResult = userRepo.countByEmail(email);
		return emailResult;
	}

/*	public boolean checkAge(User user) {
		logger.info("call checkAge()");
		
		String birth = user.getBirth();
		int age = userRepo.convertBirthToAge(birth);
		if (age > 7) {
			return true;
		} else
			return false;
	}*/
	
	public boolean checkPw(User user) {
		logger.info("call checkPw()");
		
		logger.info("user: " + user);
		String password = user.getPassword();
		String passwordCheck = user.getPasswordCheck();
		
		if (password.equals(passwordCheck)) {
			return true;
		} else
			return false;
	}
	
	public User signUp(User user) {
		logger.info("call signUp()");
		User userResult = userRepo.save(user);
		return userResult;
	}

	public Token signIn(User user) {
		logger.info("call signIn()");
		
		String email = user.getEmail();
		String password = user.getPassword();
		
		User userInfo = new User();
		userInfo.setEmail(email);
		userInfo.setPassword(password);
		int isUser = userRepo.countByEmailAndPassword(email, password);
		int isToken = tokenRepo.countByUserEmail(email);
		
		// 회원이면서 새 로그인 시
		if (isUser == 1 && isToken == 0) {
			StringBuffer token = RandomToken.createToken();
			String tokenToString = token.toString();
			
			Token tokenInfo = new Token();
			tokenInfo.setUserEmail(email);
			tokenInfo.setToken(tokenToString);
			tokenRepo.save(tokenInfo);
			Token tokenResult = tokenRepo.findByToken(tokenToString);
			return tokenResult;
		}
		// 회원이면서 재 로그인 시
		else if (isUser == 1 && isToken == 1) {
			Token userWithToken = tokenRepo.findByUserEmail(email);
			return userWithToken;
		}
		// 회원정보 잘못 입력 시
		return null;
	}

}
