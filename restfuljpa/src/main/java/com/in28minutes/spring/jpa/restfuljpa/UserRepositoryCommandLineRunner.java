package com.in28minutes.spring.jpa.restfuljpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.in28minutes.spring.jpa.restfuljpa.entity.User;
import com.in28minutes.spring.jpa.restfuljpa.repository.UserRepository;

public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;

	Optional<User> findById;
	List<User> findAll;
	
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jill", "Admin");
		
		userRepository.save(user);
		log.info("New User is created: " + user);
		
		findById = userRepository.findById(1L);
		log.info("User retrieved: " + user);
		
		findAll = userRepository.findAll();
		log.info("All Users: " + user);
	}
	

}
