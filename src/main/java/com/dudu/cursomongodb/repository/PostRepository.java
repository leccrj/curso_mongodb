package com.dudu.cursomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dudu.cursomongodb.domain.Post;

@Repository //spring data
public interface PostRepository extends MongoRepository<Post, String> {

}
