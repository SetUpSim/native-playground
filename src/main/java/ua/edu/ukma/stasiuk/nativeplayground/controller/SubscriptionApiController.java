package ua.edu.ukma.stasiuk.nativeplayground.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.stasiuk.nativeplayground.delegate.SubscriptionApiDelegate;
import ua.edu.ukma.stasiuk.nativeplayground.dto.NewSubscriptionDto;
import ua.edu.ukma.stasiuk.nativeplayground.dto.SubscriptionDto;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionApiController {
    private final SubscriptionApiDelegate subscriptionApiDelegate;

    public SubscriptionApiController(SubscriptionApiDelegate subscriptionApiDelegate) {
        this.subscriptionApiDelegate = subscriptionApiDelegate;
    }

    @GetMapping()
    public Iterable<SubscriptionDto> getSubscriptions() {
        return subscriptionApiDelegate.getSubscriptions();
    }

    @GetMapping("/with-notes")
    public Iterable<SubscriptionDto> getSubscriptionsWithNotes() {
        return subscriptionApiDelegate.getSubscriptionsWithNotes();
    }

    @PostMapping()
    public SubscriptionDto createSubscription(@Valid @RequestBody NewSubscriptionDto newSubscriptionDto) {
        return subscriptionApiDelegate.createSubscription(newSubscriptionDto);
    }
}
