package com.larionov.subscription.manager.dto;

import lombok.Builder;

@Builder
public record SubscriptionResponse(

        Long id,
        String serviceName

) {
}
