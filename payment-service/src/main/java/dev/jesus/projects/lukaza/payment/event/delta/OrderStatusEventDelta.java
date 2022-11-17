package dev.jesus.projects.lukaza.payment.event.delta;

import dev.jesus.projects.lukaza.payment.enums.OrderState;

public record OrderStatusEventDelta(Long orderId, OrderState state){
}