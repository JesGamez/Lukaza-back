package dev.jesus.projects.lukaza.payment.model;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@Table
public class Payment {

    @Id
    private Long id;
    private Long orderId;
    private Long customerId;
    private LocalDate date;
    private BigDecimal mount;

}
