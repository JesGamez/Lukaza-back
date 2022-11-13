DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_id INT(250) NOT NULL,
  description varchar(100) not null,
  price float NOT NULL
);

INSERT INTO products (product_id, description, price) VALUES
  (1, 'LG TV', 50.00),
  (2, 'LG TV', 75.00),
  (3, 'LG TV', 100.00),
  (4, 'LG TV', 500.00),
  (5, 'LG TV', 1000.00);
