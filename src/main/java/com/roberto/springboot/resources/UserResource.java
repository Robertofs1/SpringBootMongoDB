package com.roberto.springboot.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.springboot.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "maria", "maria@gmail.com");
		User Jose = new User("2", "Jose", "Jose@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, Jose));
		return ResponseEntity.ok().body(list);

	}
}
