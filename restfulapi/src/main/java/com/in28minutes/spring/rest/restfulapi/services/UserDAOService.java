package com.in28minutes.spring.rest.restfulapi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.spring.rest.restfulapi.entity.User;

@Component
public class UserDAOService {

	private static int userCount = 3;
	private static List<User> usersList = new ArrayList<>();

	static {
		usersList.add(new User(1, "Alexandre", new Date()));
		usersList.add(new User(2, "Souza", new Date()));
		usersList.add(new User(3, "Rocha", new Date()));
	}

	public List<User> findAllUsers() {
		return usersList;
	}

	public User saveUser(User user) {
		for (User users : usersList) {
			if (users.getId() == null) {

				user.setId(++userCount);
				return user;
			}
		}
		return null;
	}
	
	public User findOneUser(int id) {
		for(User user: usersList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	} 
}
