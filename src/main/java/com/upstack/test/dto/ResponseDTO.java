package com.upstack.test.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
    @NotNull
    private Boolean result;

}
