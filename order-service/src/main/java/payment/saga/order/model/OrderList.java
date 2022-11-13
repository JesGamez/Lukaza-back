package payment.saga.order.model;

import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class OrderList {

    private Integer idOrderList;

    @OneToMany(mappedBy = "idOrderDetail")
    private List<OrderDetail> OrderDetailList;
}
