package com.example.identitymanagement.dto;

import lombok.Data;

@Data
public class UserCreateRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
