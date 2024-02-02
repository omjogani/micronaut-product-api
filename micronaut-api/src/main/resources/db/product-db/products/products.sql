-- liquibase formatted sql

-- changeset om:creating-product
CREATE TABLE products (
    id varchar(256) PRIMARY KEY,
    name varchar(256) NOT NULL
) collate = utf8mb4_unicode_ci;

--changeset om:add-create-and-update-timestamp
ALTER TABLE products
    ADD createdAt TIMESTAMP,
    ADD updatedAt TIMESTAMP;
