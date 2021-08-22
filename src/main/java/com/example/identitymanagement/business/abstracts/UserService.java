package com.example.identitymanagement.business.abstracts;

import java.util.List;
import java.util.UUID;

import com.example.identitymanagement.dto.UserCreateRequestDto;
import com.example.identitymanagement.dto.UserDto;


public interface UserService {
	List<UserDto> getAllUsers();
	
	UserDto getUserById(String id);

	UserDto createUser(UserCreateRequestDto userRequest);

	void deleteUser(String id);
}
