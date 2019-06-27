package com.in28minutes.spring.rest.restfulapi.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about users.")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should atleast 2 characters")
	@ApiModelProperty(notes = "Name should atleast 2 characters.")
	private String nome;

	@Past
	@ApiModelProperty(notes = "Birthday date should be in the past.")
	private Date birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserService [id=" + id + ", nome=" + nome + ", birthDate=" + birthDate + "]";
	}
}
