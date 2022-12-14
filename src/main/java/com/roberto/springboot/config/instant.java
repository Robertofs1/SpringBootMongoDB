package com.roberto.springboot.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.roberto.springboot.domain.Post;
import com.roberto.springboot.domain.User;
import com.roberto.springboot.dto.AuthorDTO;
import com.roberto.springboot.dto.ComentsDTO;
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
		
		userRepository.saveAll(Arrays.asList(roberto, ane));

		
		Post post1 = new Post(null, sdf.parse("21/08/2022"), "Partiu bahia", "VOU VIAJAR", new AuthorDTO(roberto) );
		Post post2 = new Post(null, sdf.parse("22/09/2022"), "Partiu bahia", "VOU VIAJAR", new AuthorDTO(ane));
		
		
		ComentsDTO c1 = new ComentsDTO("Boa viagem!", sdf.parse("21/03/2022"), new AuthorDTO(roberto));
		ComentsDTO c2 = new ComentsDTO("Aproveite!", sdf.parse("25/08/2022"), new AuthorDTO(ane));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c2));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		ane.getPosts().addAll(Arrays.asList(post1 , post2));
		userRepository.save(ane);

		
	}

}
