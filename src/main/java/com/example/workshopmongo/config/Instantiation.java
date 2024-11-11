package com.example.workshopmongo.config;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User maria = new User("maria@gmail.com", "Maria Brown");
        User alex = new User("alex@gmail.com", "Alex Green");
        User bob = new User("bob@gmail.com", "Bob Grey");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
