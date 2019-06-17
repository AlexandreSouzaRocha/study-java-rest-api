package com.in28minutes.spring.jpa.restfuljpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.spring.jpa.restfuljpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
