package com.ger.repository;

import org.springframework.data.repository.CrudRepository;

import com.ger.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
