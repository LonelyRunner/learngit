package com.zh.txxml.dao;

/**
 * Created by ZH on 2017/3/29.
 */
public interface BookShopDao {

    //����������ȡ��ĵ���
    public int findBookPriceByIsbn(String isbn);

    //������Ŀ��  ʹ��Ŷ�Ӧ�Ŀ���1
    public void updateBookStock(String isbn);

    //�����û����˻�����user��balance-price
    public void updateUserAccount(String username, int price);
}
