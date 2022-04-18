package com.AiCapDesigns.springboot.app.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.AiCapDesigns.springboot.app.entity.User;

public interface UserRepository extends CrudRepository<User,Long>{
	public Optional<User> findByUsuario(String username);
}
