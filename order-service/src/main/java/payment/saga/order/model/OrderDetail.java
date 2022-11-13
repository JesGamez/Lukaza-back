package payment.saga.order.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class OrderDetail {
    private @Id Long id;
    private Long orderId;
    private Long productId;
    private Double mount;
}
