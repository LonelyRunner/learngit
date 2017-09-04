package com.zh.hibernate.service.impl;

import com.zh.hibernate.dao.BookShopDao;
import com.zh.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;

    @Override
    public void purchase(String name, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        bookShopDao.updateBookStock(isbn);

        bookShopDao.updateAccount(name,price);
    }
}
