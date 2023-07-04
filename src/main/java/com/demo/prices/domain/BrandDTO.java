package com.demo.prices.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class BrandDTO implements Serializable {

    private Long brandId;

    private String name;

}
