create table jersey_user(
       name varchar2(20) primary key not null,
       age varchar2(10) not null,
       gender varchar2(10) not null
);

--test Datas
insert into jersey_user(name,age,gender) values('����','21','��');
insert into jersey_user(name,age,gender) values('����','22','��');
insert into jersey_user(name,age,gender) values('����','24','Ů');
insert into jersey_user(name,age,gender) values('����Ӣ','42','Ů');
insert into jersey_user(name,age,gender) values('���»�','50+','��');
insert into jersey_user(name,age,gender) values('�¹���','40','��');