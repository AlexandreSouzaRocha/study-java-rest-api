package com.in28minutes.rest.webservices.restfulapi.users;

import java.util.Date;

public class Users {

	private Integer id;
	private String name;
	private Date birthDate;

	public Users(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}
