package com.larionov.subscription.manager.repository;

import com.larionov.subscription.manager.model.SubscriptionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

    List<SubscriptionEntity> findAllByUserId(Long userId);

    @Query("""
            SELECT s.name AS serviceName
            FROM SubscriptionEntity s
            GROUP BY s.name
            ORDER BY COUNT (s.id) DESC
            """)
    List<SubscriptionEntity> findTopServices(Pageable pageable);

}
