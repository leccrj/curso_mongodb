package com.dudu.cursomongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudu.cursomongodb.domain.User;
import com.dudu.cursomongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired //mecanismo de injeção de depencia automática do springboot
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
