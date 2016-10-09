package com.imooc.ssh.domain;

/**
 * Created by ZH on 2016/8/25.
 */
public class Product {

    private Integer pid;
    private String pname;
    private double price;

    public Product() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
