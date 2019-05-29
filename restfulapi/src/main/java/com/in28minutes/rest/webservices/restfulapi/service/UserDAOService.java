package com.in28minutes.rest.webservices.restfulapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restfulapi.users.User;

@Component
public class UserDAOService {
	private static int usersCount = 3;
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

		if (user.getId() == null) {

			user.setId(++usersCount);
		}

		usersList.add(user);
		return user;
	}

	public User findOneUser(int id) {

		for (User users : usersList) {
			if (users.getId() == id) {

				return users;
			}
		}

		return null;
	}
}
