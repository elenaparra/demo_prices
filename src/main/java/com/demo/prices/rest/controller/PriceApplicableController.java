package com.demo.prices.rest.controller;

import com.demo.prices.application.services.PriceService;
import com.demo.prices.domain.PriceApplicable;
import com.demo.prices.domain.PriceFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ecommerce")
public class PriceApplicableController {

    private PriceService priceService;

    public PriceApplicableController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/price")
    public ResponseEntity<PriceApplicable> getAll(@RequestBody PriceFilter priceFilter) {
        return ResponseEntity.ok(this.priceService.filterPriceAplicable(priceFilter));
    }


}
