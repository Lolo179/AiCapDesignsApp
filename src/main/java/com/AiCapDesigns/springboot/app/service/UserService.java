package com.AiCapDesigns.springboot.app.service;

import com.AiCapDesigns.springboot.app.entity.User;

public interface UserService {
	
	public Iterable<User> getAllUsers();
}
