package dev.jesus.projects.lukaza.payment.dto.request;

import java.math.BigDecimal;

public record PaymentDtoRequest(Long orderId, Long customerId, BigDecimal mount) {

}
