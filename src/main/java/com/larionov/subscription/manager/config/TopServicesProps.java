package com.larionov.subscription.manager.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TopServicesProps {

    @Value("${app.top-services.count:3}")
    private int count;

}
