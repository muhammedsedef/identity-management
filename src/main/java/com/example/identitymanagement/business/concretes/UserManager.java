package com.example.identitymanagement.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.identitymanagement.dto.UserCreateRequestDto;
import com.example.identitymanagement.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.identitymanagement.business.abstracts.UserService;
import com.example.identitymanagement.repository.abstracts.UserDao;
import com.example.identitymanagement.dto.UserDto;
import com.example.identitymanagement.model.concretes.User;

@Service
//@RequiredArgsConstructor
public class UserManager implements UserService {
	
	private final UserDao userDao;
	private final ModelMapper modelMapper;
	private PasswordEncoder passwordEncoder;


	@Autowired
	public UserManager(UserDao userDao, ModelMapper modelMapper) {
		super();
		this.userDao = userDao;
		this.modelMapper = modelMapper;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}


	@Override
	public List<UserDto> getAllUsers() {
		List <User> users = this.userDao.findAll();
		List <UserDto> dtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return dtos ;
	}

	@Override
	public UserDto getUserById(String id) {
		User user = findUserById(id);
		/*
		Optional <User> user = userDao.findById(id);
		if(user.isPresent()) {
			return modelMapper.map(user.get(), UserDto.class);
		}
		*/
		if(user != null) {
			return modelMapper.map(user, UserDto.class);
		}
		return null;
	}

	@Override
	public UserDto createUser(UserCreateRequestDto userRequest) {
		//this.passwordEncoder = new BCryptPasswordEncoder();
		User user = new User(null,
				userRequest.getFirstName(),
				userRequest.getLastName(),
				userRequest.getEmail(),
				passwordEncoder.encode(userRequest.getPassword()));

		return modelMapper.map(userDao.save(user), UserDto.class);
	}

	@Override
	public void deleteUser(String id) {
		 userDao.deleteById(id);
	}


	protected User findUserById(String id){
 		return userDao.findById(id).orElseThrow(() -> new UserNotFoundException("User cannot be found"));
	}


}
