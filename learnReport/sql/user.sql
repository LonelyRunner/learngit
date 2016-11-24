create table goodslist(
	goods_id varchar2(255),
	goods_name varchar2(255),
	cost_price number(10),
	selling_price number(10),
	manufacturer varchar2(255)
);

comment on table goodslist is "��Ʒ�б�";
comment on column goodslist.goods_id is "��Ʒid";
comment on column goodslist.goods_name is "��Ʒ����";
comment on column goodslist.cost_price is "�ɱ�";
comment on column goodslist.selling_price is "���ۼ۸�";
comment on column goodslist.manufacturer is "������";

insert into goods values('g1001','iphone6 plus',3000,6088,'made in China');
insert into goods values('g1002','iphone7',3150,6888,'made in Italy');
insert into goods values('g1003','iphone7 plus',3300,5688,'made in Japan');
insert into goods values('g1004','iphone7s',3600,6888,'made in HongKong');
insert into goods values('g1005','iphone7s plus',3650,7188,'made in TaiWan');
insert into goods values('g1006','ipad mini',1500,2888,'made in Chian');
insert into goods values('g1007','ipad air',1750,4188,'made in L.A.');
insert into goods values('g1008','mac pro',8000,12500,'made in the U.S.');
insert into goods values('g1009','hp 3100',3000,6100,'made in France');
insert into goods values('g1010','Dell index',2800,4988,'made in American');


create table trading_information(
	trading_id varchar2(255),
	trading_goods_id varchar2(255),
	trading_user_id varchar2(255),
	trading_number number(10)
);

comment on table trading_information is "�����б�";
comment on column trading_information.trading_id is "����id";
comment on column trading_information.trading_goods_id is "��Ʒid";
comment on column trading_information.trading_user_id is "�û�id";
comment on column trading_information.trading_number is "��������";

insert into trading_information values ('t00001','g1001','u101',2);
insert into trading_information values ('t00002','g1002','u101',1);
insert into trading_information values ('t00003','g1005','u101',2);
insert into trading_information values ('t00004','g1003','u102',3);
insert into trading_information values ('t00005','g1004','u102',4);
insert into trading_information values ('t00006','g1007','u102',1);
insert into trading_information values ('t00007','g1004','u103',6);
insert into trading_information values ('t00008','g1005','u103',3);
insert into trading_information values ('t00009','g1009','u103',2);
insert into trading_information values ('t000010','g1002','u104',1);
insert into trading_information values ('t000011','g1006','u104',2);
insert into trading_information values ('t000012','g1010','u104',1);
insert into trading_information values ('t000013','g1004','u105',4);
insert into trading_information values ('t000014','g1001','u105',1);
insert into trading_information values ('t000015','g1005','u105',4);

create table user_information(
	userid varchar2(255),
	name varchar2(20),
	age number(3),
	sex varchar2(2),
	area varchar2(30),
	tel number(16)
);

comment on table user_information is "�û���";
comment on column user_information.userid is "�û�id";
comment on column user_information.name is "����";
comment on column user_information.age is "����";
comment on column user_information.sex is "�Ա�";
comment on column user_information.area is "��ͥסַ";
comment on column user_information.tel is "�绰����";

insert into user_infomation values ('u101','����',23,'��','�����к���������·',18233334444);
insert into user_infomation values ('u102','����',21,'Ů','�����г���������·',18255554444);
insert into user_infomation values ('u103','����',23,'Ů','�����з�ɽ������·',18266664444);
insert into user_infomation values ('u104','����',24,'��','�����з�̨������·',18277774444);
insert into user_infomation values ('u105','����',27,'Ů','�����в�ƽ������·',18288884444);
