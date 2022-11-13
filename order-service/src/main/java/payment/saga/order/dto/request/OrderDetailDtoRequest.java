package payment.saga.order.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Id;

@Getter
@Builder
public class OrderDetailDtoRequest {
    private Long productId;
    private Double mount;
}
