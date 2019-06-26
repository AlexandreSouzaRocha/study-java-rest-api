package com.in28minutes.spring.rest.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.spring.rest.restfulapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer > {

}
