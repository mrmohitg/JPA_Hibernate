use mydb;
create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);
insert into product values (1,"IPhone","Awesome",1000);
insert into product values (2,"IPad","Great",500);
insert into product values (3,"IWatch","Wonder",250);
insert into product values (4,"MacBookPro","Super",10000);
insert into product values (5,"AirBuds","Tiney",300);
insert into product values (6,"ApplePencil","Amazing",150);
insert into product values (7,"AppleTV","Bigger",20050);
select * from product;
delete from product where name = 'IPhone'; 
commit;

use mydb;
create table customer(
id int PRIMARY KEY auto_increment,
name varchar(20),
email varchar(100) 
);
select * from customer;

drop table customer;

/*For GenerationType.IDENTITY */
create table employee(
id int primary key auto_increment,
name varchar(20)
);

drop table employee;
delete from employee where id =102;

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
select * from id_gen;
