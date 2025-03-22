package ua.edu.ukma.stasiuk.nativeplayground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ukma.stasiuk.nativeplayground.domain.mapper.SubscriptionMapper;
import ua.edu.ukma.stasiuk.nativeplayground.dto.SubscriptionDto;
import ua.edu.ukma.stasiuk.nativeplayground.repository.SubscriptionRepository;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionController(SubscriptionRepository subscriptionRepository,
                                  SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    @GetMapping()
    public Iterable<SubscriptionDto> getSubscriptions() {
        var entities = subscriptionRepository.findAll();
        var dtos = subscriptionMapper.convertSubscriptionEntityListToDtoList(entities);

        return dtos;
    }
}
