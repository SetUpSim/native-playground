package ua.edu.ukma.stasiuk.nativeplayground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.edu.ukma.stasiuk.nativeplayground.domain.SubscriptionEntity;

import java.util.List;
import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {

    @Query("select s from SubscriptionEntity s where s.notes is not null")
    List<SubscriptionEntity> findAllByNotesNotNull();

}