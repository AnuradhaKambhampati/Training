package com.hnt.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/")
	public String getUser() {
		return "test";
	}
	
	@PostMapping("/saveUser")
	public int createUser(@Valid @RequestBody User user) {
		service.saveUser(user);
		return user.getId();
		
	}
	
	@PostMapping("/age/{age}")
	public int saveUser(@Valid @RequestBody User user, @PathVariable("age") int age) {
		user.setAge(age);
		service.saveUser(user);
		return user.getId();
	}
	
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	//ResponseEntity 
	@PostMapping("/user/age/{age}")
	public ResponseEntity saveUsers(@RequestBody User user, @PathVariable("age") int age) {
		user.setAge(age);
		//service.saveUser(user);
		MultiValueMap<String , String> headers= new LinkedMultiValueMap<>();
		headers.add("headerFromServer", "Success");
		ResponseEntity response=new ResponseEntity(headers, HttpStatus.CONFLICT);
		return response;
	}

}
