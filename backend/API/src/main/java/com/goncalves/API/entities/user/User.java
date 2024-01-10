package com.goncalves.API.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "user")
public class User {

    @Id
    private String idUsers;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birth;


    public User(String username, String firstName, String lastName, String email, String password, String birth) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birth = birth;
    }

}
