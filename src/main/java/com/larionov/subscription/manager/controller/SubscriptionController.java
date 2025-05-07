package com.larionov.subscription.manager.controller;

import com.larionov.subscription.manager.dto.SubscriptionRequest;
import com.larionov.subscription.manager.dto.SubscriptionResponse;
import com.larionov.subscription.manager.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;

    @PostMapping(path = "/users/{id}/subscriptions",
            consumes = "application/json",
            produces = "application/json")
    public SubscriptionResponse addSubscription(@PathVariable Long id,
                                                @Valid @RequestBody SubscriptionRequest request) {
        return service.add(id, request);
    }

    @GetMapping(path = "/users/{id}/subscriptions",
            consumes = "application/json",
            produces = "application/json")
    public List<SubscriptionResponse> getAllSubscriptions(@PathVariable Long id) {
        return service.getSubscriptions(id);
    }

    @DeleteMapping(path = "/users/{id}/subscriptions/{sub_id}",
            consumes = "application/json",
            produces = "application/json")
    public void deleteSubscription(@PathVariable Long subId) {
        service.delete(subId);
    }

    @GetMapping(path = "/subscriptions/top",
            consumes = "application/json",
            produces = "application/json")
    public List<SubscriptionResponse> getTopSubscriptions() {
        return service.getTopServices();
    }

}
