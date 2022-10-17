package com.upstack.test.controllers;

import com.upstack.test.dto.ResponseDTO;
import com.upstack.test.dto.UserViewObject;
import com.upstack.test.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/users")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody UserViewObject userViewObject) throws IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authenticationService.checkCredentials(userViewObject));
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveUser(@Valid @RequestBody UserViewObject userViewObject) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authenticationService.saveCredentials(userViewObject));
    }

}
