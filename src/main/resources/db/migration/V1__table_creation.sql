CREATE SCHEMA IF NOT EXISTS ECOMMERCE;
SET SCHEMA ECOMMERCE;
CREATE TABLE brand
(
    brand_id bigint NOT NULL PRIMARY KEY,
    name     VARCHAR(255)
);

CREATE TABLE product
(
    product_id bigint NOT NULL PRIMARY KEY,
    name       VARCHAR(255)
);

CREATE TABLE price
(
    price_id   bigint         NOT NULL,
    brand_id   bigint         NOT NULL,
    start_date timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    end_date   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    product_id bigint         NOT NULL,
    priority   bigint         NOT NULL,
    price      decimal(15, 2) NOT NULL,
    curr       VARCHAR(255)
);

ALTER TABLE
    price
    ADD CONSTRAINT brand_id_fk FOREIGN KEY (brand_id) REFERENCES brand (brand_id);

ALTER TABLE
    price
    ADD CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES product (product_id);