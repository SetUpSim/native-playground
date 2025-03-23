package ua.edu.ukma.stasiuk.nativeplayground.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "subscription", uniqueConstraints = @UniqueConstraint(
        name = SubscriptionEntityConstraints.SERVICE_NAME_UNIQUE,
        columnNames = "serviceName"
))
public class SubscriptionEntity {
    @UuidGenerator
    @Id
    private UUID id;

    @Column(length = 50, unique = true, nullable = false)
    private String serviceName;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal cost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillingCycle billingCycle;

    @Column(length = 100, nullable = false)
    private String category;

    @Column(length = 500)
    private String notes;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean active;
}
