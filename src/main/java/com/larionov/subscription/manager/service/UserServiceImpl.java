package com.larionov.subscription.manager.service;

import com.larionov.subscription.manager.dto.UserDTORequest;
import com.larionov.subscription.manager.dto.UserDTOResponse;
import com.larionov.subscription.manager.exception.NotFoundException;
import com.larionov.subscription.manager.model.UserEntity;
import com.larionov.subscription.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserDTOResponse create(UserDTORequest request) {
        UserEntity user = UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .build();

        UserEntity newUser = repository.save(user);
        return new UserDTOResponse(newUser.getId(), newUser.getName(), newUser.getEmail());
    }

    public UserDTOResponse get(Long id) {
        UserEntity user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));

        return new UserDTOResponse(user.getId(), user.getName(), user.getEmail());
    }

    public UserDTOResponse update(Long id, UserDTORequest request) {
        UserEntity user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));

        user.setName(request.name());
        user.setEmail(request.email());
        repository.save(user);
        return new UserDTOResponse(user.getId(), user.getName(), user.getEmail());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("User not found: " + id);
        }
        repository.deleteById(id);
    }

}
