package com.demo.prices.application.services;

import com.demo.prices.domain.PriceApplicable;
import com.demo.prices.domain.PriceFilter;
import com.demo.prices.infrastructure.entity.Price;
import com.demo.prices.infrastructure.mappers.PriceMapper;
import com.demo.prices.infrastructure.query.spec.PriceSpec;
import com.demo.prices.infrastructure.repositories.PriceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@Transactional
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    @Override
    public PriceApplicable filterPriceAplicable(PriceFilter priceFilter) {
        return this.priceMapper.toPriceApplicable(priceRepository.findAll(PriceSpec.buildFilter(priceFilter))
                .stream().max(Comparator.comparing(Price::getPriority)).get());
    }
}
