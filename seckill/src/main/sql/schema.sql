--秒杀库存表
create table seckill(
     seckill_id NUMBER NOT NULL,
     name VARCHAR2(50) NOT NULL,
     quantity NUMBER NOT NULL,
     start_time DATE NOT NULL,
     end_time DATE NOT NULL,
     create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE seckill ADD CONSTRAINT pk_seckill PRIMARY KEY (seckill_id);
COMMENT ON TABLE seckill is '秒杀库存表';
COMMENT ON COLUMN seckill.seckill_id is '商品库存id';
COMMENT ON COLUMN seckill.name is '商品名称';
COMMENT ON COLUMN seckill.quantity is '库存数量';
COMMENT ON COLUMN seckill.start_time is '秒杀开启时间';
COMMENT ON COLUMN seckill.end_time is '秒杀结束时间';
COMMENT ON COLUMN seckill.create_time is '创建时间';

--插入秒杀物品详细数据
insert into seckill (seckill_id,name,quantity,start_time,end_time)
      values (1000,'iphone6 plus',300,to_date('2016-09-09 10:10:10','YYYY-MM-DD HH24:MI:SS'),to_date('2016-09-09 11:11:11','YYYY-MM-DD HH24:MI:SS'));
insert into seckill (seckill_id,name,quantity,start_time,end_time)
      values (1001,'iPad air2',200,to_date('2016-09-10 10:10:10','YYYY-MM-DD HH24:MI:SS'),to_date('2016-09-10 11:11:11','YYYY-MM-DD HH24:MI:SS'));
insert into seckill (seckill_id,name,quantity,start_time,end_time)
      values (1002,'数码相机',300,to_date('2016-09-11 10:10:10','YYYY-MM-DD HH24:MI:SS'),to_date('2016-09-11 11:11:11','YYYY-MM-DD HH24:MI:SS'));
insert into seckill (seckill_id,name,quantity,start_time,end_time)
      values (1003,'稻香村月饼',400,to_date('2016-09-12 10:10:10','YYYY-MM-DD HH24:MI:SS'),to_date('2016-09-12 11:11:11','YYYY-MM-DD HH24:MI:SS'));
--秒杀成功明细表
create table success_killed(
    seckill_id NUMBER NOT NULL,
    user_phone NUMBER NOT NULL,
    state NUMBER DEFAULT -1 NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE success_killed ADD CONSTRAINT pk_success_killed PRIMARY KEY (seckill_id,user_phone);
COMMENT ON TABLE success_killed is '秒杀成功明细表';
COMMENT ON COLUMN success_killed.seckill_id is '秒杀商品id';
COMMENT ON COLUMN success_killed.user_phone is '用户手机号';
COMMENT ON COLUMN success_killed.state is '状态标示-1:无效 0:成功 1:已付款 2:已发货';
COMMENT ON COLUMN success_killed.create_time is '创建时间';