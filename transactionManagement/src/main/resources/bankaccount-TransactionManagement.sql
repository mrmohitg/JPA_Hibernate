use mydb;

create table bankaccount (accountnumber int,lastname varchar(25),firstname varchar(25),balance int);

insert into bankaccount values(1,'obama','barack',5000);

insert into bankaccount values(2,'donald','trump',4000);

select * from bankaccount;

drop table bankaccount;