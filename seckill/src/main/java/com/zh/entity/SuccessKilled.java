package com.zh.entity;

import java.util.Date;

/**
 * Created by ZH on 2016/9/7.
 */
public class SuccessKilled {
    private long seckillId;

    private long number;

    private int state;

    private Date createTime;

    private Seckill seckill;

    public SuccessKilled() {
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "createTime=" + createTime +
                ", state=" + state +
                ", number=" + number +
                ", seckillId=" + seckillId +
                '}';
    }
}
