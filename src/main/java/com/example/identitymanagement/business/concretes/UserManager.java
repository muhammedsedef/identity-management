package com.example.identitymanagement.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.identitymanagement.business.abstracts.UserService;
import com.example.identitymanagement.repository.abstracts.UserDao;
import com.example.identitymanagement.dto.UserDto;
import com.example.identitymanagement.model.concretes.User;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
	
	private final UserDao userDao;
	private final ModelMapper modelMapper;

	/*
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	*/

	@Override
	public List<UserDto> getAllUsers() {
		List <User> users = this.userDao.findAll();
		List <UserDto> dtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return dtos ;
	}

	@Override
	public UserDto getUserById(int id) {
		Optional <User> user = userDao.findById(id);
		
		if(user.isPresent()) {
			return modelMapper.map(user.get(), UserDto.class);
		}
		return null;
	}

}
