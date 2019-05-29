package com.in28minutes.rest.webservices.restfulapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulapi.service.UserDAOService;
import com.in28minutes.rest.webservices.restfulapi.users.User;

@RestController
public class UsersResource {

	@Autowired
	private UserDAOService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping("find-one/{id}")
	public User retrieveOneUser(@PathVariable int id) {
		return service.findOneUser(id);
	}

}
