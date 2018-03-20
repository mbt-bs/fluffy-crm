SET client_encoding = 'UTF8';

DROP TABLE IF EXISTS customer;
CREATE TABLE customer
(
    id      BIGINT PRIMARY KEY NOT NULL,
    name    VARCHAR(250)       NOT NULL,
    date    DATE,
    phone   VARCHAR(20),
    email   VARCHAR(100),
    comment TEXT
);
INSERT INTO customer (name, date, phone, email, comment)
VALUES ('Иванов Иван Иванович', '1987-11-29', '+79994863265', 'ivan@ivan.ru', 'тест1');
INSERT INTO customer (name, date, phone, email, comment)
VALUES ('Петров Пётр Петрович', '1992-12-14', '+79998469537', 'petr@petr.ru', 'тест2');
INSERT INTO customer (name, date, phone, email, comment)
VALUES ('Сидоров Сидор Сидорович', '1984-12-07', '+79997359658', 'sidr@sidr.ru', 'тест3');

DROP TABLE IF EXISTS service;
CREATE TABLE service
(
    id    BIGINT PRIMARY KEY NOT NULL,
    title VARCHAR(250)       NOT NULL
);
INSERT INTO service (title) VALUES ('тест1');
INSERT INTO service (title) VALUES ('тест2');
INSERT INTO service (title) VALUES ('тест3');

DROP TABLE IF EXISTS works;
CREATE TABLE works
(
    id          BIGINT PRIMARY KEY NOT NULL,
    customer_id SERIAL             NOT NULL,
    service_id  SERIAL             NOT NULL,
    date        DATE
);
INSERT INTO works (customer_id, service_id, date) VALUES (1, 1, current_date);
INSERT INTO works (customer_id, service_id, date) VALUES (2, 2, current_date);
INSERT INTO works (customer_id, service_id, date) VALUES (3, 3, current_date);
