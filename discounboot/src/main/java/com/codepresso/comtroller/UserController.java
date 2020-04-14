package com.codepresso.comtroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.domain.ResponseVO;
import com.codepresso.domain.Token;
import com.codepresso.domain.User;
import com.codepresso.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseVO signUp(@RequestBody User user) throws Exception {
		logger.info("call signUp()");
		logger.info("user: " + user);

		int emailResult = userService.checkEmail(user);
		boolean ageResult = userService.checkAge(user);
		boolean pwResult = userService.checkPw(user);

		if (emailResult == 0 && ageResult == true && pwResult == true) {
			User userResult = userService.signUp(user);
			ResponseVO result = new ResponseVO();
			result.setCode(HttpStatus.OK);
			result.setMessage("SUCCESS");
			result.setData(userResult);
			return result;
		} else {
			ResponseVO result = new ResponseVO();
			result.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			result.setMessage("FAIL");
			result.setData(null);
			return result;
		}
	}

	@PostMapping("/signin")
	public ResponseVO signIn(@RequestBody User user) throws Exception {
		logger.info("call signIn()");

		Token userResult = userService.signIn(user);
		ResponseVO result = new ResponseVO();
		result.setCode(HttpStatus.OK);
		result.setMessage("SUCCESS");
		result.setData(userResult);
		return result;
	}
}
