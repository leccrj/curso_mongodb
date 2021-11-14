package com.dudu.cursomongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dudu.cursomongodb.domain.User;
import com.dudu.cursomongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired //injeção de dependencia
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();
		
		User maria = new User(null,"Maria Brown","maria@gmail.com");
		User alex = new User(null,"Alex Green","alex@gmail.com");
		User bob = new User(null,"Bob Grey","bob@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
