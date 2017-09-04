package com.zh.hibernate.service.impl;

import com.zh.hibernate.service.BookShopService;
import com.zh.hibernate.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    public void checkout(String username,List<String> isbns){
        for(String isbn : isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
