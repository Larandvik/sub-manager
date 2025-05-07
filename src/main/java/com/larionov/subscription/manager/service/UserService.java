package com.larionov.subscription.manager.service;

import com.larionov.subscription.manager.dto.UserDTORequest;
import com.larionov.subscription.manager.dto.UserDTOResponse;

public interface UserService {

    UserDTOResponse create(UserDTORequest userDTORequest);

    UserDTOResponse get(Long id);

    UserDTOResponse update(Long id, UserDTORequest request);

    void delete(Long id);

}
