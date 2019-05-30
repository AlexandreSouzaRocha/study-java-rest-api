package com.in28minutes.spring.rest.restfulapi.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.core.DummyInvocationUtils;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.spring.rest.restfulapi.entities.User;
import com.in28minutes.spring.rest.restfulapi.exceptions.UserNotFoundException;
import com.in28minutes.spring.rest.restfulapi.services.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping(value = "/users")
	public List<User> retrieveAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping("/find-user")
	public Resource<User> retrieveOneUser(@RequestParam int id) {
		User findUser = service.findOneuser(id);

		if (findUser == null)
			throw new UserNotFoundException("User " + id + "  Not found");

		Resource<User> resource = new Resource<User>(findUser);

		ControllerLinkBuilder linkTo = 
				ControllerLinkBuilder.linkTo(this.getClass(),
						retrieveAllUsers());
		resource.add(linkTo.withRel("add-user"));

		return resource;
	}

	@DeleteMapping("/delete-user")
	public void deleteUser(@RequestParam int id) {
		User deleteUser = service.deleteUserById(id);

		if (deleteUser == null)
			throw new UserNotFoundException("User " + id + "  Not found");

	}

	@PostMapping(value = "/create-user", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saveUser = service.saveUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
