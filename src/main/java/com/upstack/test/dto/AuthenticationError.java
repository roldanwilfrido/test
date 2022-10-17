package com.upstack.test.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class AuthenticationError {
    private Instant time;
    private Integer status;
    private String message;
}
