package com.edu.workshopmongo.services;

import com.edu.workshopmongo.domain.User;
import com.edu.workshopmongo.dto.UserDTO;
import com.edu.workshopmongo.repository.UserRepository;
import com.edu.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(User userObj) {
        repo.delete(userObj);
    }
    public void deleteById(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}