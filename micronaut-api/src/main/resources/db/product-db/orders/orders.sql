-- liquibase formatted sql

-- changeset om:creating-orders
CREATE TABLE orders (
    id varchar(256) PRIMARY KEY,
    quantity int NOT NULL,
    amount decimal(5,2) NOT NULL,
    createdAt TIMESTAMP
) collate = utf8mb4_unicode_ci;


-- changeset om:add-productId
ALTER TABLE orders
    ADD productId varchar(256) REFERENCES products(id);