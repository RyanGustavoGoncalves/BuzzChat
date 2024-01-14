package com.goncalves.API.controller;

import com.goncalves.API.DTO.DataListingUser;
import com.goncalves.API.entities.user.User;
import com.goncalves.API.entities.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<DataListingUser>> getUsers(@PageableDefault(size = 10, sort = {"creationAccount"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DataListingUser::new);
        return ResponseEntity.ok(page);
    }


}
