package payment.saga.order.model;

import lombok.Data;
import lombok.ToString;
import payment.saga.order.enums.OrderStatus;

import javax.persistence.*;

@Data
@Entity
@ToString
public class OrderPurchase {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private OrderStatus status;
}
