package com.upstack.test.configurations;

import com.upstack.test.dto.AuthenticationError;
import com.upstack.test.exceptions.UserCredentialAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@ControllerAdvice
@RestController
public class AuthenticationExceptionHandler {

    @ExceptionHandler(UserCredentialAlreadyExistException.class)
    public ResponseEntity<AuthenticationError> alreadyExistException(Exception ex) {
        AuthenticationError authenticationError = AuthenticationError.builder()
                .time(Instant.now())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .message("The user credentials already exist!")
                .build();
        return new ResponseEntity<>(authenticationError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AuthenticationError> notNullException(Exception ex) {
        AuthenticationError authenticationError = AuthenticationError.builder()
                .time(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Username and Password must be filled. Please check.")
                .build();
        return new ResponseEntity<>(authenticationError, HttpStatus.BAD_REQUEST);
    }
}
