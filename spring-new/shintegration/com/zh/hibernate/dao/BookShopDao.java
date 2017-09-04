package com.zh.hibernate.dao;

/**
 * Created by ZH on 2017/3/30.
 */
public interface BookShopDao {

    /** ������Ż�ȡ��ĵ��� */
    public int findBookPriceByIsbn(String isbn);

    /** ������Ŀ��  ʹ֮-1 */
    public void updateBookStock(String isbn);

    /** �����û����˻���� ʹaccount-price */
    public void updateAccount(String username,int price);

    /** ������������ */
    public void testInsertData();
}
