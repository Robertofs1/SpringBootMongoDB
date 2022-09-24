package com.roberto.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.springboot.domain.User;
import com.roberto.springboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository  repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

}
