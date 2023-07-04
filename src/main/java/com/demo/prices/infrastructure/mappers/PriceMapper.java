package com.demo.prices.infrastructure.mappers;

import com.demo.prices.domain.PriceApplicable;
import com.demo.prices.infrastructure.entity.Price;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {PriceMapper.class})
public interface PriceMapper {

    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "startDate", target = "dateApplicable")
    @InheritConfiguration
    PriceApplicable toPriceApplicable(Price entity);
}
