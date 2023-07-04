package com.demo.prices.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PriceApplicable implements Serializable {

    private Long priceId;

    @JsonProperty("brand")
    private BrandDTO brand;

    private Date dateApplicable;

    @JsonProperty("product")
    private ProductDTO product;

    private Double price;
}
