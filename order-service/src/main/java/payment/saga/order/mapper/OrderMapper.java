package payment.saga.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import payment.saga.order.dto.request.OrderDtoRequest;
import payment.saga.order.enums.OrderStatus;
import payment.saga.order.model.OrderPurchase;
import payment.saga.order.model.OrderPurchaseEvent;

@Mapper(componentModel = "spring", imports = {OrderStatus.class})
public interface OrderMapper {
    @Mapping(target = "status", expression = "java(OrderStatus.CREATED)")
    OrderPurchase map(OrderDtoRequest orderRequest);

    @Mapping(target = "orderId", source = "id")
    OrderPurchaseEvent map(OrderPurchase orderPurchase);
}