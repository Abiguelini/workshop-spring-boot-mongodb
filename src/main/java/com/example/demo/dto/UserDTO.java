package com.example.demo.dto;

import java.io.Serializable;
import java.util.Optional;

import com.example.demo.domain.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
	public UserDTO(Optional<User> obj) {
		
	}
	
	public UserDTO() {
		super();
	}

	public UserDTO(User user) {
		id = user.getId();
		name  = user.getName();
		email = user.getEmail();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
