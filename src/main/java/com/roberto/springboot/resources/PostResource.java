package com.roberto.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.springboot.domain.Post;
import com.roberto.springboot.services.PostService;

@RestController
@RequestMapping(value = "/users")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
		
	
	
	
}