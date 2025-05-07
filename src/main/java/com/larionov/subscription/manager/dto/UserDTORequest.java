package com.larionov.subscription.manager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserDTORequest(

        @NotBlank(message = "Name must not be empty")
        String name,

        @NotBlank(message = "Email must not be empty")
        @Email(message = "Email must be correct")
        String email

) {
}
