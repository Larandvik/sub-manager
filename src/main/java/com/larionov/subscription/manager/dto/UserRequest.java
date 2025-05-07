package com.larionov.subscription.manager.dto;

import lombok.Builder;

@Builder
public record UserRequest(

        String name,
        String email

) {
}
