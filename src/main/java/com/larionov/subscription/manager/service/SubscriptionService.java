package com.larionov.subscription.manager.service;

import com.larionov.subscription.manager.config.TopServicesProps;
import com.larionov.subscription.manager.dto.SubscriptionRequest;
import com.larionov.subscription.manager.dto.SubscriptionResponse;
import com.larionov.subscription.manager.exception.NotFoundException;
import com.larionov.subscription.manager.model.SubscriptionEntity;
import com.larionov.subscription.manager.model.UserEntity;
import com.larionov.subscription.manager.repository.SubscriptionRepository;
import com.larionov.subscription.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subRepository;
    private final TopServicesProps props;

    public SubscriptionResponse add(Long userId, SubscriptionRequest request) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found: " + userId));
        SubscriptionEntity subscription = SubscriptionEntity.builder()
                .user(user)
                .name(request.serviceName())
                .build();

        subRepository.save(subscription);
        return new SubscriptionResponse(subscription.getId(), subscription.getName());
    }

    public List<SubscriptionResponse> getSubscriptions(Long userId) {
        return subRepository.findAllByUserId(userId).stream()
                .map(sub -> new SubscriptionResponse(sub.getId(), sub.getName()))
                .toList();
    }

    public void delete(Long id) {
        if (!subRepository.existsById(id)) {
            throw new NotFoundException("Subscription not found");
        }
        subRepository.deleteById(id);
    }

    public List<SubscriptionResponse> getTopServices() {
        Pageable page = PageRequest.of(0, props.getCount());
        List<SubscriptionEntity> topServices = subRepository.findTopServices(page);
        return topServices.stream()
                .map(sub -> new SubscriptionResponse(sub.getId(), sub.getName()))
                .toList();
    }

}
