package com.larionov.subscription.manager.dto;

import lombok.Builder;

@Builder
public record UserDTOResponse(

        Long id,
        String name,
        String email

) {
}
