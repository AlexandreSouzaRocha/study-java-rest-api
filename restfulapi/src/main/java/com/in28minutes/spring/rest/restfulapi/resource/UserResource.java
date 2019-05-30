package com.in28minutes.spring.rest.restfulapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.spring.rest.restfulapi.entity.User;
import com.in28minutes.spring.rest.restfulapi.services.UserDAOService;

@RestController
public class UserResource {
	
	@Autowired
	private UserDAOService service;
	
	@GetMapping("/users")
	public List<User>retreiveAllUsers(){
		return service.findAllUsers();
	}

}
