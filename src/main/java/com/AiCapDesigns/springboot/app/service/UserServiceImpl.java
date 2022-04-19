package com.AiCapDesigns.springboot.app.service;

import java.util.Optional;

import org.hibernate.mapping.Set;
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
		if(user.getConfirmPassword()==null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirm password es obligatorio");
		}
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



	@Override
	public User getUserById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario a editar no existe"));
	}



	@Override
	public User updateUser(User fromUser) throws Exception {
		User toUser = getUserById(fromUser.getId());
		mapUser (fromUser,toUser);
		 return repository.save(toUser);
		
	}
	//Mapeamos todo a excepcion del password
	protected void mapUser(User from, User to) {
		to.setUsuario(from.getUsuario());
		to.setNombre(from.getNombre());
		to.setApellidos(from.getApellidos());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}
}
