package com.larionov.subscription.manager.dto;

import lombok.Builder;

@Builder
public record UserDTORequest(

        String name,
        String email

) {
}
