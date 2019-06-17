package com.in28minutes.spring.jpa.restfuljpa;

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
	
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jill", "Admin");
		
		userRepository.save(user);
		log.info("New User is created: " + user);
	}
	

}
