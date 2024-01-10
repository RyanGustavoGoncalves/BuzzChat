package com.goncalves.API.DTO;

import com.goncalves.API.entities.user.User;

public record DataNewUser(String username, String firstName, String lastName, String email, String password, String birth) {

    public DataNewUser (User user){
        this(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getBirth());
    }
}
