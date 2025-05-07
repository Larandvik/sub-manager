package com.larionov.subscription.manager.dto;

import lombok.Builder;

@Builder
public record SubscriptionRequest(

        String serviceName

) {
}
