package com.example.workshopmongo.config;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.AuthorDTO;
import com.example.workshopmongo.repository.PostRepository;
import com.example.workshopmongo.repository.UserRepository;
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

        User maria = new User("maria@gmail.com", "Maria Brown");
        User alex = new User("alex@gmail.com", "Alex Green");
        User bob = new User("bob@gmail.com", "Bob Grey");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null,sdf.parse("21/03/2018"),"Partiu Viagem", "Viajar para são paulo", new AuthorDTO(maria)  );
        Post p2 = new Post(null,sdf.parse("23/05/2018"),"Partiu Viagem", "Viajar para Rio de Janeiro", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(p1,p2));

        maria.getPosts().addAll(Arrays.asList(p1,p2));
        userRepository.save(maria);
    }
}
