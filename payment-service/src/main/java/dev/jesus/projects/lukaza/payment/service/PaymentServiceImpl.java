package dev.jesus.projects.lukaza.payment.service;

import dev.jesus.projects.lukaza.payment.dto.request.PaymentDtoRequest;
import lombok.RequiredArgsConstructor;
import dev.jesus.projects.lukaza.payment.mapper.PaymentMapper;
import dev.jesus.projects.lukaza.payment.model.Payment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import dev.jesus.projects.lukaza.payment.repository.PaymentRepository;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public Mono<Payment> create(Mono<PaymentDtoRequest> paymentRequestMono) {
        return paymentRequestMono.map(paymentMapper::fromDto).flatMap(paymentRepository::save);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return paymentRepository.deleteById(id);
    }


}
