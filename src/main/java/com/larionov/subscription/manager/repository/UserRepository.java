package com.larionov.subscription.manager.repository;

import com.larionov.subscription.manager.model.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @EntityGraph(attributePaths = "subscriptions")
    Optional<UserEntity> findById(Long id);

}
