use mydb;

CREATE TABLE products (
    id int NOT NULL ,
    name varchar(255) NOT NULL,
    price int NOT NULL,
    PRIMARY KEY (id,name)
);

select * from products;


drop table products;
