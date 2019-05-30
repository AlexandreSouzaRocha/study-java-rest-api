package com.in28minutes.spring.rest.restfulapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.spring.rest.restfulapi.entities.User;
import com.in28minutes.spring.rest.restfulapi.services.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAllUsers();
	}
}
