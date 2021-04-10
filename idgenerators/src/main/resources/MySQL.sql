use mydb;
create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);
select * from product;
delete from product where name = 'IPhone'; 
commit;

create table customer(
id int PRIMARY KEY,
name varchar(20),
email varchar(100) 
);

/*For GenerationType.IDENTITY */
create table employee(
id int primary key auto_increment,
name varchar(20)
);

drop table employee;

/*For GenerationType.TABLE */
create table employee(
id int primary key,
name varchar(20)
);
create table id_gen(
gen_name varchar(60) primary key,
gen_val int(20)
);

select * from employee;
