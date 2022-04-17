package com.AiCapDesigns.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AiCapDesigns.springboot.app.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{

}
