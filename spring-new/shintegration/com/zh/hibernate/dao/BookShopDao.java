package com.zh.hibernate.dao;

/**
 * Created by ZH on 2017/3/30.
 */
public interface BookShopDao {

    /** 根据书号获取书的单价 */
    public int findBookPriceByIsbn(String isbn);

    /** 更新书的库存  使之-1 */
    public void updateBookStock(String isbn);

    /** 更新用户的账户余额 使account-price */
    public void updateAccount(String username,int price);

    /** 新增测试数据 */
    public void testInsertData();
}
