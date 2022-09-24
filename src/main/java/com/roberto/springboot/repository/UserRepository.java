package com.roberto.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.roberto.springboot.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

}
