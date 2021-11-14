package com.dudu.cursomongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudu.cursomongodb.domain.User;
import com.dudu.cursomongodb.repository.UserRepository;
import com.dudu.cursomongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired //mecanismo de injeção de depencia automática do springboot
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
