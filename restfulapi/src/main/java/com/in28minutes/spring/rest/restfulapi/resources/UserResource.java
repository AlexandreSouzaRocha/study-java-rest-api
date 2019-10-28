package com.in28minutes.spring.rest.restfulapi.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.spring.rest.restfulapi.entities.Post;
import com.in28minutes.spring.rest.restfulapi.entities.User;
import com.in28minutes.spring.rest.restfulapi.exceptions.UserNotFoundException;
import com.in28minutes.spring.rest.restfulapi.repository.PostRepository;
import com.in28minutes.spring.rest.restfulapi.repository.UserRepository;

@RestController
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping(value = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/find-user")
	public Resource<User> retrieveOneUser(@RequestParam int id) {
		Optional<User> findUser = userRepository.findById(id);

		if (!findUser.isPresent())
			throw new UserNotFoundException("User " + id + "  Not found");

		Resource<User> resource = new Resource<User>(findUser.get());

		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(this.getClass(), retrieveAllUsers());
		resource.add(linkTo.withRel("add-user"));

		return resource;
	}

	@DeleteMapping("/jpa/delete-user")
	public void deleteUser(@RequestParam int id) {
		userRepository.deleteById(id);
	}

	@PostMapping(value = "/jpa/create-user", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		@Valid
		User save = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping(value = "/jpa/{id}/create-post", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {

		Optional<User> findUser = userRepository.findById(id);

		if (!findUser.isPresent())
			throw new UserNotFoundException("User " + id + "  Not found");

		User user = findUser.get();

		post.setUser(user);
		postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
