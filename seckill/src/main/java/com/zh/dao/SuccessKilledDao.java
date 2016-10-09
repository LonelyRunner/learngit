package com.zh.dao;

import com.zh.entity.SuccessKilled;

/**
 * Created by ZH on 2016/9/7.
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细 可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 在使用Mybatis时,如果dao方法为添加、删除、修改,则可以用int类型来做返回类型.返回的是受影响的行数,
     *         如果为0则表示执行了sql语句后数据库记录没有受影响.
     *         如果为具体数字则表示执行sql以后受影响的记录行数.
     */
    int insertSeckillId(long seckillId,long userPhone);


    /**
     * 根据id查询successKilled并携带有秒杀产品对象
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId);
}
