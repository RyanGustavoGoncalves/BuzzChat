package com.goncalves.API.DTO;

import com.goncalves.API.entities.user.User;

import java.time.LocalDateTime;

public record DataListingUser(String idUsers,
                              String username,
                              String firstName,
                              String lastName,
                              String email,
                              String password,
                              String birth,
                              LocalDateTime createAccount) {
    public DataListingUser (User user){
        this(
            user.getIdUsers(),
            user.getUsername(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPassword(),
            user.getBirth(),
            user.getCreateAccount()
        );
    }
}
