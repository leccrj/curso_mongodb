package com.dudu.cursomongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dudu.cursomongodb.domain.Post;
import com.dudu.cursomongodb.domain.User;
import com.dudu.cursomongodb.dto.AuthorDTO;
import com.dudu.cursomongodb.repository.PostRepository;
import com.dudu.cursomongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired //injeção de dependencia
	private UserRepository userRepo;

	@Autowired //injeção de dependencia
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null,"Maria Brown","maria@gmail.com");
		User alex = new User(null,"Alex Green","alex@gmail.com");
		User bob = new User(null,"Bob Grey","bob@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("16/11/2021"),"Partiu viagem","Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("17/11/2021"),"Bom dia","Acordei feliz hoje!",new AuthorDTO(maria));

		postRepo.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepo.save(maria);
	}

}
