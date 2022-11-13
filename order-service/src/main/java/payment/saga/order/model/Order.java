package payment.saga.order.model;

import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Order {
    private Long id;
    private Long userId;
    private List<OrderDetail> orderDetails;
    private Integer amount;
}
