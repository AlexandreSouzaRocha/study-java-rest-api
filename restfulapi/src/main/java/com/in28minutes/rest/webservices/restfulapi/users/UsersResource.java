package com.in28minutes.rest.webservices.restfulapi.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersResource {

	@Autowired
	private UserDAOService services;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return services.findAllUsers();
	}

	@GetMapping("/users/find-one")
	public User retrieveOneUser(@RequestParam int id) {
		return services.findOneUser(id);
	}
}
