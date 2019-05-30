package com.in28minutes.spring.rest.restfulapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.spring.rest.restfulapi.entities.User;

@Component
public class UserService {

	private static int userCount = 3;
	private static List<User> usersList = new ArrayList<>();

	public List<User> findAllUsers() {
		return usersList;
	}

	public User saveUser(User user) {

		if (user.getId() == null) {
			user.setId(++userCount);
		}
		usersList.add(user);
		return user;
	}

	public User findOneuser(int id) {
		for (User user : usersList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
