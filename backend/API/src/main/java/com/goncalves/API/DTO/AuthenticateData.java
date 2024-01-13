package com.goncalves.API.DTO;

import java.time.LocalDateTime;

public record AuthenticateData(String username,
                               String firstName,
                               String lastName,
                               String email,
                               String password,
                               String birth,
                               LocalDateTime creationAccount,
                               byte[] profileImage) {
}
