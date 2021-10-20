package com.ketul.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ketul.demo.exception.UserNotFoundException;
import com.ketul.demo.module.User;
import com.ketul.demo.module.dto.UserDto;

@RestController
public class MyController {
	
	@Autowired
	private UserDto userDto;
	
	@GetMapping("/users")
	public List<User> getAll() {
		return userDto.getAll();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> getOne(@PathVariable int id) {
		
		User user = userDto.getOne(id);
		
		if(user == null)
			throw new UserNotFoundException("ID :- " + id + " not found");
		
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAll());  
		
		resource.add(linkTo.withRel("all-users"));  
		
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		User user = userDto.deleteById(id);
		
		if(user == null)
			throw new UserNotFoundException("ID :- " + id + " not found");
		
		
	}
	
	@PostMapping("user")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		User savedUser = userDto.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
