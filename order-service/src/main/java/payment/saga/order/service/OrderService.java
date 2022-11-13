package payment.saga.order.service;

import payment.saga.order.dto.request.OrderDtoRequest;
import payment.saga.order.model.OrderPurchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderService {
    Mono<OrderPurchase> createOrder(OrderDtoRequest orderRequest);

    Flux<OrderPurchase> getAll();

    Flux<OrderPurchase> reactiveGetAll();

    Mono<OrderPurchase> getOrderById(Integer id);
}
