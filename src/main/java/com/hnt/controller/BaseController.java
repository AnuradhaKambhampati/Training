package com.hnt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

	public BaseController() {
		super();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException e) {
		Map<String,String> errorMap=new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String field=((FieldError) error).getField();
			String message=((FieldError) error).getDefaultMessage();
			errorMap.put(field, message);
		});
		return errorMap;
	}

}