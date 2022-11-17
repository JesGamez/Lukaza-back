package dev.jesus.projects.lukaza.payment.service;

import dev.jesus.projects.lukaza.payment.dto.request.PaymentDtoRequest;
import dev.jesus.projects.lukaza.payment.model.Payment;
import reactor.core.publisher.Mono;

public interface PaymentService {
    Mono<Payment> create(Mono<PaymentDtoRequest> paymentRequestMono);
    Mono<Void> delete(Long id);
}
