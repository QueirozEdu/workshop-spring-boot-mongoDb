package com.edu.workshopmongo.config;

import com.edu.workshopmongo.domain.Post;
import com.edu.workshopmongo.domain.User;
import com.edu.workshopmongo.dto.AuthorDTO;
import com.edu.workshopmongo.dto.CommentDTO;
import com.edu.workshopmongo.repository.PostRepository;
import com.edu.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@email.com");
        User alex = new User(null, "Alex Green", "alex@email.com");
        User bob = new User(null, "Bob Grey", "bob@email.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("01/01/2025"), "Lets go!", "Going on a road trip", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("02/02/2025"), "Good morning", "Woke up feeling great", new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Have a nice trip!!", sdf.parse("01/01/2025"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Enjoy", sdf.parse("02/01/2025"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Have a nice day!", sdf.parse("02/02/2025"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
