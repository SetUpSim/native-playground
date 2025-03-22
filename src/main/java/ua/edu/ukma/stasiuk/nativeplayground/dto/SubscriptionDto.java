package ua.edu.ukma.stasiuk.nativeplayground.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class SubscriptionDto {

    private UUID id;

    private String serviceName;

    private BigDecimal cost;

    private String billingCycle;

    private String category;

    private String notes;

    private Boolean active;

}
