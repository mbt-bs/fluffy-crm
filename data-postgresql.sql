SET client_encoding = 'UTF8';

CREATE TABLE whitefox.client
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(250) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    comment TEXT
);