create table jersey_user(
       name varchar2(20) primary key not null,
       age varchar2(10) not null,
       gender varchar2(10) not null
);

--test Datas
insert into jersey_user(name,age,gender) values('张三','21','男');
insert into jersey_user(name,age,gender) values('李四','22','男');
insert into jersey_user(name,age,gender) values('王五','24','女');
insert into jersey_user(name,age,gender) values('刘若英','42','女');
insert into jersey_user(name,age,gender) values('刘德华','50+','男');
insert into jersey_user(name,age,gender) values('陈冠蒲','40','男');