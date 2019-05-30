package com.in28minutes.spring.rest.restfulapi.entities;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	private Integer id;
	
	@Size(min = 2)
	private String nome;
	
	@Past
	private Date birthDate;

	protected User() {

	}

	public User(Integer id, String nome, Date birthDate) {
		super();
		this.id = id;
		this.nome = nome;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "UserService [id=" + id + ", nome=" + nome + ", birthDate=" + birthDate + "]";
	}
}
