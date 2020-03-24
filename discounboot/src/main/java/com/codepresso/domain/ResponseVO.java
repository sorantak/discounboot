package com.codepresso.domain;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseVO {

	private HttpStatus code;
	private String message;
	private Object data;
}
