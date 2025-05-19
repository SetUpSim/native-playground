package ua.edu.ukma.stasiuk.nativeplayground.controller;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.stasiuk.nativeplayground.delegate.SubscriptionApiDelegate;
import ua.edu.ukma.stasiuk.nativeplayground.dto.NewSubscriptionDto;
import ua.edu.ukma.stasiuk.nativeplayground.dto.SubscriptionDto;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionApiController {

    private final static Logger logger = LogManager.getLogger();

    private final String stringValue;
    private final boolean booleanValue;
    private final SubscriptionApiDelegate subscriptionApiDelegate;

    public SubscriptionApiController(@Value("#{valueService.getSomeString()}") String stringValue,
                                     @Value("#{valueService.getConstantFalse()}") boolean booleanValue,
                                     SubscriptionApiDelegate subscriptionApiDelegate) {
        this.stringValue = stringValue;
        this.booleanValue = booleanValue;
        this.subscriptionApiDelegate = subscriptionApiDelegate;

        logger.info("string value: {}", stringValue);
        logger.info("boolean value: {}", booleanValue);
    }

    @GetMapping()
    @PreAuthorize("@valueService.getConstantTrue()")
    public Iterable<SubscriptionDto> getSubscriptions() {
        return subscriptionApiDelegate.getSubscriptions();
    }

    @GetMapping("/with-notes")
    @PreAuthorize("T(java.lang.Boolean).FALSE")
    public Iterable<SubscriptionDto> getSubscriptionsWithNotes() {
        return subscriptionApiDelegate.getSubscriptionsWithNotes();
    }

    @PostMapping()
    public SubscriptionDto createSubscription(@Valid @RequestBody NewSubscriptionDto newSubscriptionDto) {
        return subscriptionApiDelegate.createSubscription(newSubscriptionDto);
    }
}
