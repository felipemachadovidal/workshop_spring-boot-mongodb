package com.example.workshopmongo.resources;

import com.example.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("maria@email.com", "1", "Maria Brown");
        User alex = new User("alex@email.com", "2", "Alex Green");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
