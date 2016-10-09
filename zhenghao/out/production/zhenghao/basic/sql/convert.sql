create table t_jss(
  st_date varchar2(10),
  id varchar2(10),
  valueA number(5)
);
--                       date      id     value
insert into t_jss values('110901','1001',1232);
insert into t_jss values('110901','1001',3321);
insert into t_jss values('110901','1001',12233);
insert into t_jss values('110901','1001',1223);
insert into t_jss values('110901','1001',1233);
insert into t_jss values('110901','1001',1263);

insert into t_jss values('110902','1002',12613);
insert into t_jss values('110902','1002',12623);
insert into t_jss values('110902','1002',12633);
insert into t_jss values('110902','1002',12643);
insert into t_jss values('110902','1002',12653);
insert into t_jss values('110902','1002',12663);

insert into t_jss values('110903','1003',11263);
insert into t_jss values('110903','1003',12263);
insert into t_jss values('110903','1003',13263);
insert into t_jss values('110903','1003',12463);
insert into t_jss values('110903','1003',15263);
insert into t_jss values('110903','1003',18263);


//列转行
SELECT a.st_date,wm_concat(a.valueA)
FROM t_jss a
group by a.st_date;

--
select * from (select st_date, valueA from t_jss)
pivot
(count(valueA) for valueA in ('valueA1','valueA2','valueA3','valueA4','valueA5','valueA6'));


select * from
  (select st_date,valueA '')


select st_date,id,valueA from t_jss group by id