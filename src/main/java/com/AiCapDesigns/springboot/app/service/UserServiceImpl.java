package com.AiCapDesigns.springboot.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AiCapDesigns.springboot.app.entity.User;
import com.AiCapDesigns.springboot.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	
	
	
	public boolean CheckUsernameExist(User user) throws Exception {
		Optional<User> userFound = repository.findByUsuario(user.getUsuario());
		if(userFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
	}
	private boolean CheckPasswordValid(User user) throws Exception {
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Password y confirm no son iguales");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws Exception {
		if(CheckUsernameExist(user)&& CheckPasswordValid(user)) {
			user=repository.save(user);
		}
		return user;
	}
}
