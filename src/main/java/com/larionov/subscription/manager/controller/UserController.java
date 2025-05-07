package com.larionov.subscription.manager.controller;

import com.larionov.subscription.manager.dto.UserDTORequest;
import com.larionov.subscription.manager.dto.UserDTOResponse;
import com.larionov.subscription.manager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public UserDTOResponse create(@Valid @RequestBody UserDTORequest request) {
        return service.create(request);
    }

    @GetMapping(path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public UserDTOResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping(path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public UserDTOResponse update(@PathVariable Long id, @Valid @RequestBody UserDTORequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
