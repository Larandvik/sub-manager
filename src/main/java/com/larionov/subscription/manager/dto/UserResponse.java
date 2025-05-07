package com.larionov.subscription.manager.dto;

import lombok.Builder;

@Builder
public record UserResponse(

        Long id,
        String name,
        String email

) {
}
