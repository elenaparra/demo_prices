package com.demo.prices.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceFilter {


    private Long brandId;

    private Long productId;

    private String dateApplicable;

    public PriceFilter(Long brandId, Long productId, String dateApplicable) {
        this.brandId = brandId;
        this.productId = productId;
        this.dateApplicable = dateApplicable;
    }
}
