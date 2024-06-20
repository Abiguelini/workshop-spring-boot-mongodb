package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	public Optional<User> findById(String id) {
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return user;
		
	}
}
