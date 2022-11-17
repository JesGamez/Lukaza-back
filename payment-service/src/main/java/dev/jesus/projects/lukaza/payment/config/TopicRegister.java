package dev.jesus.projects.lukaza.payment.config;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TopicRegister {
    public static final String PREFIX = "4oocksxz-";
    public static final String ORDER_STATE = PREFIX + "order-state";
}
