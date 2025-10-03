package com.edu.workshopmongo.repository;

import com.edu.workshopmongo.domain.Post;
import com.edu.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}