package com.demo.prices.integration.controller;

import com.demo.prices.domain.PriceFilter;
import com.demo.prices.infrastructure.util.JsonUtil;
import com.demo.prices.integration.WebMVCTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class PriceApplicableControllerTest extends WebMVCTest {

    private static final String TEST_1 = "35.5";
    private static final String TEST_2 = "25.45";
    private static final String TEST_3 = "35.5";
    private static final String TEST_4 = "30.5";
    private static final String TEST_5 = "38.95";
    private static final Long BRAND_ID = 1L;
    private static final Long PRODUCT_ID = 35455L;


    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenBrandProductAndDate_whenGetPrice_thenPriceAplicable_test_1() throws Exception {
        String date = "2020-06-14 10:00:00";
        PriceFilter priceFilter = new PriceFilter(BRAND_ID, PRODUCT_ID, date);
        String path = "/api/ecommerce/price";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(path)
                                .content(JsonUtil.objectToString(priceFilter))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(TEST_1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void givenBrandProductAndDate_whenGetPrice_thenPriceAplicable_test_2() throws Exception {
        String date = "2020-06-14 16:00:00";
        PriceFilter priceFilter = new PriceFilter(BRAND_ID, PRODUCT_ID, date);
        String path = "/api/ecommerce/price";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(path)
                                .content(JsonUtil.objectToString(priceFilter))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(TEST_2))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void givenBrandProductAndDate_whenGetPrice_thenPriceAplicable_test_3() throws Exception {
        String date = "2020-06-14 21:00:00";
        PriceFilter priceFilter = new PriceFilter(BRAND_ID, PRODUCT_ID, date);
        String path = "/api/ecommerce/price";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(path)
                                .content(JsonUtil.objectToString(priceFilter))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(TEST_3))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void givenBrandProductAndDate_whenGetPrice_thenPriceAplicable_test_4() throws Exception {
        String date = "2020-06-15 10:00:00";
        PriceFilter priceFilter = new PriceFilter(BRAND_ID, PRODUCT_ID, date);
        String path = "/api/ecommerce/price";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(path)
                                .content(JsonUtil.objectToString(priceFilter))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(TEST_4))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void givenBrandProductAndDate_whenGetPrice_thenPriceAplicable_test_5() throws Exception {
        String date = "2020-06-16 21:00:00";
        PriceFilter priceFilter = new PriceFilter(BRAND_ID, PRODUCT_ID, date);
        String path = "/api/ecommerce/price";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(path)
                                .content(JsonUtil.objectToString(priceFilter))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(TEST_5))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
