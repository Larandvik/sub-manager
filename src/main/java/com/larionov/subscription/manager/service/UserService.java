package com.larionov.subscription.manager.service;

import com.larionov.subscription.manager.dto.UserRequest;
import com.larionov.subscription.manager.dto.UserResponse;
import com.larionov.subscription.manager.exception.NotFoundException;
import com.larionov.subscription.manager.model.UserEntity;
import com.larionov.subscription.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserResponse create(UserRequest request) {
        UserEntity user = UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .build();
        UserEntity newUser = repository.save(user);
        return new UserResponse(newUser.getId(), newUser.getName(), newUser.getEmail());
    }

    public UserResponse getById(Long id) {
        UserEntity user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));

        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    public UserResponse update(Long id, UserRequest request) {
        UserEntity user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));

        user.setName(request.name());
        user.setEmail(request.email());
        repository.save(user);
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("User not found: " + id);
        }
        repository.deleteById(id);
    }

}
