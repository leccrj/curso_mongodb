package com.dudu.cursomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dudu.cursomongodb.domain.User;

@Repository //spring data
public interface UserRepository extends MongoRepository<User, String> {

}
