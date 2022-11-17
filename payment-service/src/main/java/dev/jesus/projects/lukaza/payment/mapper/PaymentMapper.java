package dev.jesus.projects.lukaza.payment.mapper;

import dev.jesus.projects.lukaza.payment.dto.request.PaymentDtoRequest;
import dev.jesus.projects.lukaza.payment.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PaymentMapper {
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "id", ignore = true)
    Payment fromDto(PaymentDtoRequest request);
}
