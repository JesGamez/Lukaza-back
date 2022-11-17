package dev.jesus.projects.lukaza.payment.controller;

import dev.jesus.projects.lukaza.payment.dto.request.PaymentDtoRequest;
import lombok.RequiredArgsConstructor;
import dev.jesus.projects.lukaza.payment.model.Payment;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import dev.jesus.projects.lukaza.payment.service.PaymentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Mono<Payment> create(@RequestBody Mono<PaymentDtoRequest> paymentRequestMono){
        return paymentService.create(paymentRequestMono);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return paymentService.delete(id);
    }

}
