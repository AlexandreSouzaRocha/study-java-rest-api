package com.in28minutes.spring.rest.restfulapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

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

	@GetMapping("/find-one")
	public User retrieveOnesers(@RequestParam int id) {
		return service.findOneuser(id);
	}

	@PostMapping(value = "/create-user", consumes= "application/json")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User saveUser = service.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
