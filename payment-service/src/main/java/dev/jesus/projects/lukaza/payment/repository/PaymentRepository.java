package dev.jesus.projects.lukaza.payment.repository;

import dev.jesus.projects.lukaza.payment.model.Payment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PaymentRepository extends R2dbcRepository<Payment, Long> {
}
