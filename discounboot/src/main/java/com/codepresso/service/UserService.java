package com.codepresso.service;

import java.util.Calendar;

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

	public int checkEmail(User user) {
		logger.info("call checkEmail()");

		String email = user.getEmail();
		int emailResult = userRepo.countByEmail(email);
		return emailResult;
	}

	public boolean checkAge(User user) {
		logger.info("call checkAge()");

		String birth = user.getBirth();
		String birthYear = birth.substring(0, 4);
		int birthYear2 = Integer.parseInt(birthYear);
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int userAge = thisYear - birthYear2;
		logger.info("userAge: " + userAge);
		if (userAge > 7) {
			return true;
		} else
			return false;
	}

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

		User userInfo1 = new User();
		userInfo1.setEmail(email);
		userInfo1.setPassword(password);
		int isUser = userRepo.countByEmailAndPassword(email, password);
		User userInfo2 = userRepo.findByEmail(email);
		Long userId = userInfo2.getId();
		int isToken = tokenRepo.countByUserId(userId);

		// 회원이면서 새 로그인 시
		if (isUser == 1 && isToken == 0) {
			StringBuffer token = RandomToken.createToken();
			String tokenToString = token.toString();

			Token tokenInfo = new Token();
			tokenInfo.setUser(userInfo2);
			tokenInfo.setToken(tokenToString);
			logger.info("tokenInfo(새로 생성된 토큰): " + tokenInfo);
			tokenRepo.save(tokenInfo);
			logger.info("findByToken 실행");
			Token tokenResult = tokenRepo.findByToken(tokenToString);
			logger.info("findByToken 실행(토큰으로 사용자 조회): " + tokenResult);
			return tokenResult;
		}
		// 회원이면서 재 로그인 시
		else if (isUser == 1 && isToken == 1) {
			Token userWithToken = tokenRepo.findByUserId(userId);
			userWithToken.setUser(userInfo2);
			return userWithToken;
		}
		// 회원정보 잘못 입력 시
		return null;
	}

}
