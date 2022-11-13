package payment.saga.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import payment.saga.order.dto.request.OrderDetailDtoRequest;
import payment.saga.order.model.OrderDetail;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetail map(OrderDetailDtoRequest orderDetail);

    @Mapping(target = "orderId", source = "orderId")
    OrderDetail map(OrderDetailDtoRequest orderDetail, Long orderId);
}
