package com.zh.txxml.dao;

/**
 * Created by ZH on 2017/3/29.
 */
public interface BookShopDao {

    //根据书名获取书的单价
    public int findBookPriceByIsbn(String isbn);

    //更新书的库存  使书号对应的库存减1
    public void updateBookStock(String isbn);

    //更新用户的账户余额：是user的balance-price
    public void updateUserAccount(String username, int price);
}
