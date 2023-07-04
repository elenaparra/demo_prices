package com.demo.prices.infrastructure.query.spec;

import com.demo.prices.domain.PriceFilter;
import com.demo.prices.infrastructure.entity.*;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PriceSpec {


    public static Specification<Price> buildFilter(PriceFilter priceFilter) {
        Specification<Price> paramsMatch = null;

        if (priceFilter.getBrandId() != null) {
            paramsMatch = Specification.where(paramsMatch).and(byBrand(priceFilter.getBrandId()));
        }
        if (priceFilter.getProductId() != null) {
            paramsMatch = Specification.where(paramsMatch).and(byProduct(priceFilter.getProductId()));
        }

        if (priceFilter.getDateApplicable() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(priceFilter.getDateApplicable(), formatter);
            paramsMatch = Specification.where(paramsMatch).and(byDate(dateTime));
        }
        return paramsMatch;

    }

    private static Specification<Price> byBrand(final Long branId) {
        return (Root<Price> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Join<Price, Brand> joinBrand = root.join(Price_.brand, JoinType.INNER);
            return criteriaBuilder.equal(joinBrand.get(Brand_.brandId), branId);
        };
    }

    private static Specification<Price> byProduct(final Long productId) {
        return (Root<Price> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Join<Price, Product> joinProducto = root.join(Price_.product, JoinType.INNER);
            return criteriaBuilder.equal(joinProducto.get(Product_.productId), productId);
        };
    }

    private static Specification<Price> byDate(final LocalDateTime localDateTime) {
        return (Root<Price> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.lessThanOrEqualTo(root.get(Price_.startDate), criteriaBuilder.literal(localDateTime)),
                criteriaBuilder.greaterThanOrEqualTo(root.get(Price_.endDate), criteriaBuilder.literal(localDateTime))
        );
    }


}
