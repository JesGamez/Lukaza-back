package payment.saga.order.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import payment.saga.order.mapper.OrderMapper;
import payment.saga.order.model.OrderPurchase;
import payment.saga.order.model.OrderPurchaseEvent;
import reactor.core.publisher.Sinks;

@Component
@RequiredArgsConstructor
public class OrderPurchaseProcessor {
    private final Sinks.Many<OrderPurchaseEvent> sink;
    private final OrderMapper orderMapper;

    public void process(OrderPurchase orderPurchase) {
        OrderPurchaseEvent orderPurchaseEvent = orderMapper.map(orderPurchase);
        sink.emitNext(orderPurchaseEvent, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
