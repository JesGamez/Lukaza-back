package payment.saga.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import payment.saga.order.dto.request.OrderDtoRequest;
import payment.saga.order.mapper.OrderDetailMapper;
import payment.saga.order.mapper.OrderMapper;
import payment.saga.order.model.OrderDetail;
import payment.saga.order.model.OrderPurchase;
import payment.saga.order.processor.OrderPurchaseProcessor;
import payment.saga.order.repository.OrderDetailRepository;
import payment.saga.order.repository.OrderPurchaseRepository;
import payment.saga.order.repository.ProductRepository;
import payment.saga.order.service.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderPurchaseRepository orderPurchaseRepository;
    private final OrderPurchaseProcessor orderPurchaseProcessor;
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final Scheduler jdbcScheduler;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    @Override
    public Mono<OrderPurchase> createOrder(OrderDtoRequest orderRequest) {
        OrderPurchase orderPurchase = orderMapper.map(orderRequest);

        return orderPurchaseRepository.save(orderPurchase)
                .switchIfEmpty(Mono.error(Exception::new))
                .map(order -> {
                    Flux.fromIterable(orderRequest.getOrderDetails())
                            .map(orderDetail -> {
                                OrderDetail detail = orderDetailMapper.map(orderDetail, order.getId());
                                return orderDetailRepository.save(detail);
                            });
                    return order;
                })
                .doOnNext(orderPurchaseProcessor::process);
    }

    @Override
    public Flux<OrderPurchase> getAll() {
        return Flux.defer(orderPurchaseRepository::findAll)
                .subscribeOn(jdbcScheduler);
    }

    @Override
    public Flux<OrderPurchase> reactiveGetAll() {
        Flux<Long> interval = Flux.interval(Duration.ofMillis(2000));
        Flux<OrderPurchase> orderPurchaseFlux = orderPurchaseRepository.findAll();
        return Flux.zip(interval, orderPurchaseFlux)
                .map(Tuple2::getT2);
    }

    @Override
    public Mono<OrderPurchase> getOrderById(Integer id) {
        return orderPurchaseRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Order id: " + id + " does not exist")
                ))
                .subscribeOn(jdbcScheduler);
    }


}
