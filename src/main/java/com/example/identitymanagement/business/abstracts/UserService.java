package com.example.identitymanagement.business.abstracts;

import java.util.List;

import com.example.identitymanagement.dto.UserDto;


public interface UserService {
	List<UserDto> getAllUsers();
	
	UserDto getUserById(int id);
}
