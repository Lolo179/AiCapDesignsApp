package com.AiCapDesigns.springboot.app.service;

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

}
