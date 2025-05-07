package com.larionov.subscription.manager.dto;

import lombok.Builder;

@Builder
public record SubscriptionDTOResponse(

        Long id,
        String serviceName

) {
}
