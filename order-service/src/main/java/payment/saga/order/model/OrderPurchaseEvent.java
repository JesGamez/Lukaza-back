package payment.saga.order.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderPurchaseEvent implements Event {
    private static final String EVENT = "OrderPurchase";
    private Long orderId;
    private Long userId;
    private BigDecimal total;

    @Override
    public String getEvent() {
        return EVENT;
    }
}
