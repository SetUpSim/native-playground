package ua.edu.ukma.stasiuk.nativeplayground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.stasiuk.nativeplayground.domain.SubscriptionEntity;

import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {
}