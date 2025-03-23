package ua.edu.ukma.stasiuk.nativeplayground.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
public class NewSubscriptionDto {

    @NotNull
    @Length(min = 2, max = 50)
    private String serviceName;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal cost;

    @NotNull
    @Pattern(regexp = "WEEKLY|MONTHLY|YEARLY")
    private String billingCycle;

    @NotNull
    @Length(min = 2, max = 100)
    private String category;

    @Length(max = 500)
    private String notes;

}
