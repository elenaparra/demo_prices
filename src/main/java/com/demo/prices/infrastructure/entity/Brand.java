package com.demo.prices.infrastructure.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "brand")
public class Brand {

    @Id
    @Column(name = "brand_id")
    private Long brandId;

    private String name;

}
