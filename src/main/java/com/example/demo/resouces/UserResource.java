package com.example.demo.resouces;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserService;
import com.example.demo.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)
 	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO>listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public User findById(@PathVariable String id) {
		Optional<User> obj = service.findById(id);
		new UserDTO(obj);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Id não encontrado"));
		
	}
}
