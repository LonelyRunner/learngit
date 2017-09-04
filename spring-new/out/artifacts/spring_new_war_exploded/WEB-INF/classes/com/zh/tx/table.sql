create table book(
       isbn varchar2(50) primary key,
       book_name varchar2(100),
       price number(10)
);

create table book_stock(
       isbn varchar2(50) primary key,
       stock number(10),
       check(stock > 0)
);

create table account(
       username varchar2(50) primary key,
       balance number(10),
       check(balance > 0)
);

select * from book
select * from account
select * from book_stock

--test data

insert into book values('1001','java',100);
insert into book values('1002','oracle',70);

insert into account values('tom',3000);

insert into book_stock values('1001',10);
insert into book_stock values('1002',10);
