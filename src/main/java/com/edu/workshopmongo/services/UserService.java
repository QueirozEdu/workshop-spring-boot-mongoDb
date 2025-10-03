package com.edu.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;

import com.edu.workshopmongo.domain.User;
import com.edu.workshopmongo.repository.UserRepository;
import com.edu.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        if(user==null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }
}