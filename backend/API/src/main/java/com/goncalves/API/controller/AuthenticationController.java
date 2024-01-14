package com.goncalves.API.controller;

import com.goncalves.API.DTO.AuthenticateData;
import com.goncalves.API.entities.user.User;
import com.goncalves.API.entities.user.UserRepository;
import com.goncalves.API.infra.security.*;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private ErrorHandling errorHandling;

    @PostMapping("/register")
    public ResponseEntity register(@RequestPart("profileImage") MultipartFile profileImage,
                                   @RequestPart("userData") @Valid AuthenticateData data,
                                   UriComponentsBuilder uriComponentsBuilder) {
        try {
            validateRegistrationData(data);

            // Criar um novo usuário com a senha criptografada
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

            // Converta o MultipartFile para byte[]
            byte[] profileImageBytes = profileImage.getBytes();

            User newUser = new User(data.username(), data.firstName(), data.lastName(), data.email(),
                    encryptedPassword, data.birth(), LocalDateTime.now(), profileImageBytes);
            repository.save(newUser);

            // Construir a URI para o novo usuário
            var uri = uriComponentsBuilder.path("/users/{id_User}").buildAndExpand(newUser.getIdUsers()).toUri();

            // Retornar uma resposta 201 Created com a URI e o corpo do novo usuário
            return ResponseEntity.created(uri).body(newUser);
        } catch (RegistrationException e) {
            return ResponseEntity.badRequest().body(new StandardError(e.getField(), e.getMessage()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void validateRegistrationData(AuthenticateData data) throws RegistrationException {
        if (repository.findByUsername(data.username()) != null) {
            throw new RegistrationException("username", "Já existe um usuário com este nome!");
        }
        validateField(data.firstName(), "firstName", "Campo firstName deve ter no mínimo 3 caracteres!");
        validateField(data.lastName(), "lastName", "Campo lastName deve ter no mínimo 3 caracteres!");
        validateField(data.username(), "username", "Campo usuário deve ter no mínimo 3 caracteres!");
        validateField(data.email(), "email", "Campo email vazio!");
        validateField(data.password(), "password", "Campo senha deve ter no mínimo 8 caracteres!");
        validateField(data.birth(), "birth", "Campo birth não pode ser nulo");
        }

    private void validateField(String value, String fieldName, String errorMessage) throws RegistrationException {
        if (StringUtils.isBlank(value) || value.length() < 3) {
            throw new RegistrationException(fieldName, errorMessage);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticateData data) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());

            var authentication = manager.authenticate(authenticationToken);
            //Tratamento de erro caso as credenciais estejam erradas

            var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorValidation("Credenciais inválidas"));
        }
    }
}