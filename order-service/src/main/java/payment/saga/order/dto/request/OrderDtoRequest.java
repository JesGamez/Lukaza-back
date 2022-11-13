package payment.saga.order.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderDtoRequest {
    @Deprecated
    private Long id;
    private Long userId;
    private List<OrderDetailDtoRequest> orderDetails;
    private Integer total;
}
