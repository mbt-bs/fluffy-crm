SET client_encoding = 'UTF8';

DROP TABLE IF EXISTS customer;
CREATE TABLE customer
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(250) NOT NULL,
    date DATE,
    phone VARCHAR(20),
    email VARCHAR(100),
    comment TEXT
);
INSERT INTO customer (name, date, phone, email, comment) VALUES ('Иванов Иван Иванович', '1987-11-29', '+79994863265', 'ivan@ivan.ru', 'тест1');
INSERT INTO customer (name, date, phone, email, comment) VALUES ('Петров Пётр Петрович', '1992-12-14', '+79998469537', 'petr@petr.ru', 'тест2');
INSERT INTO customer (name, date, phone, email, comment) VALUES ('Сидоров Сидор Сидорович', '1984-12-07', '+79997359658', 'sidr@sidr.ru', 'тест3');