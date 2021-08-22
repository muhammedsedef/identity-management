package com.example.identitymanagement.api.controllers;

import java.util.List;
import java.util.UUID;

import com.example.identitymanagement.dto.UserCreateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List <UserDto> usersDto = this.userService.getAllUsers();
		return ResponseEntity.ok(usersDto);
		
	}
	
	@GetMapping("/getUserById/{id}") // domanin/api/users/getUserById/1 (Get) request
	public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
		UserDto userDto = this.userService.getUserById(id);
		return ResponseEntity.ok(userDto);
	}

	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserCreateRequestDto userRequest){
		return ResponseEntity.ok(userService.createUser(userRequest));
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		this.userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}

	
	/*
	@GetMapping("getUserById") // domanin/api/users/getUserById/id=1 (Get) request
	public User getUserById(@RequestParam int id) {
		return this.userService.getUserById(id);
	}
	*/
}
