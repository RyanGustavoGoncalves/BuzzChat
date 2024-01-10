package com.goncalves.API.controller;

import com.goncalves.API.DTO.DataNewUser;
import com.goncalves.API.entities.user.User;
import com.goncalves.API.entities.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getUser (){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity registerUser(@Validated @RequestBody DataNewUser data){
        var newUser = repository.save(new User(
                data.username(),
                data.firstName(),
                data.lastName(),
                data.email(),
                data.password(),
                data.birth()
        ));

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
