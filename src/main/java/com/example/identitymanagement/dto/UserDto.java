package com.example.identitymanagement.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
