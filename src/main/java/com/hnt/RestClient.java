package com.hnt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hnt.entity.User;


public class RestClient {
	public static void main(String[] args) {
		get();
		//post();
		//postOther();
	}
	
	private static void get() {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:8081/user/users", String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCodeValue());
		
	}
	
	private static void post() {
		User user=new User();
		user.setName("Priya");
		user.setAge(49);
		RestTemplate restTemplate=new RestTemplate();
		Integer response = restTemplate.postForObject("http://localhost:8081/user/saveUser", user,Integer.class, new HashMap<>());
		System.out.println(response);
	}
	
//	private static void postOther() {
//		User user=new User();
//		user.setName("Ramya");
//		Map<String, Integer> map=new HashMap<>();
//		map.put("age", 9);
//		RestTemplate restTemplate=new RestTemplate();
//		Integer response = restTemplate.postForObject("http://localhost:8081/user/age", user,Integer.class, map);
//		System.out.println(response);
//	}
	
}
