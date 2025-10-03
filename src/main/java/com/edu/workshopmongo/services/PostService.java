package com.edu.workshopmongo.services;

import com.edu.workshopmongo.domain.Post;
import com.edu.workshopmongo.domain.User;
import com.edu.workshopmongo.repository.PostRepository;
import com.edu.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post post = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        if (post == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return post;
    }


}