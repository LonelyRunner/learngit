package com.zh.tx.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZH on 2017/3/29.
 */
@Service(value="cashier")
public class CashierImpl implements Cashier{

    @Autowired
    private BookShopService bookShopService;

    public void checkout(String username,List<String> isbns){

        for(String isbn : isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
