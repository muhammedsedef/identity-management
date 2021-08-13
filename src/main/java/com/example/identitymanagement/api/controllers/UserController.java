package com.example.identitymanagement.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.identitymanagement.business.abstracts.UserService;
import com.example.identitymanagement.dto.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	/*
	@Autowired //Projeyi tarayıp productService i kim implemente etmiş ise gidip manager clası bulup newleyip injection yapıyor
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}*/
	
	@GetMapping("/getAllUsers") // domanin/api/users/getAllUsers (Get) request
	public List<UserDto> getAllUsers() {
		List <UserDto> usersDto = this.userService.getAllUsers();
		return usersDto;
		
	}
	
	@GetMapping("/getUserById/{id}") // domanin/api/users/getUserById/1 (Get) request
	public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
		UserDto userDto = this.userService.getUserById(id);
		return ResponseEntity.ok(userDto);
	}
	
	/*
	@GetMapping("getUserById") // domanin/api/users/getUserById/id=1 (Get) request
	public User getUserById(@RequestParam int id) {
		return this.userService.getUserById(id);
	}
	*/
}
