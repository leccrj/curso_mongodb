package com.dudu.cursomongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudu.cursomongodb.domain.Post;
import com.dudu.cursomongodb.repository.PostRepository;
import com.dudu.cursomongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired //mecanismo de injeção de depencia automática do springboot
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContaining(text);
	}
}
