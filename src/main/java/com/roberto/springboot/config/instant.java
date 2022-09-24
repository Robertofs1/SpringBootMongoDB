package com.roberto.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.roberto.springboot.domain.User;
import com.roberto.springboot.repository.UserRepository;

@Configuration
public class instant implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User roberto = new User(null, "roberto ", "roberto@gmail.com");
		User ane = new User(null, "Ane", "ane@gmail.com");
		
		
		userRepository.saveAll(Arrays.asList(roberto, ane));
		
	}

}
