package com.demo.prices.application.services;

import com.demo.prices.domain.PriceApplicable;
import com.demo.prices.domain.PriceFilter;

public interface PriceService {

    PriceApplicable filterPriceAplicable(PriceFilter priceFilter);

}
