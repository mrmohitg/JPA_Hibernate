use mydb;
create table customer(
id int PRIMARY KEY auto_increment,
name varchar(20),
email varchar(100) 
);
select * from customer;

drop table customer;