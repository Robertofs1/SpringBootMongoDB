package com.roberto.springboot.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.roberto.springboot.domain.Post;
import com.roberto.springboot.domain.User;
import com.roberto.springboot.repository.PostRepository;
import com.roberto.springboot.repository.UserRepository;

@Configuration
public class instant implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		postRepository.deleteAll();
		
		User roberto = new User(null, "roberto ", "roberto@gmail.com");
		User ane = new User(null, "Ane", "ane@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/08/2022"), "Partiu bahia", "VOU VIAJAR", roberto );
		Post post2 = new Post(null, sdf.parse("22/09/2022"), "Partiu bahia", "VOU VIAJAR", ane);
		
		
		userRepository.saveAll(Arrays.asList(roberto, ane));
		postRepository.saveAll(Arrays.asList(post1, post2));

		
	}

}
