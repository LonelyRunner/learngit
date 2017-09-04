package com.zh.tx.Service;

import java.util.List;

/**
 * Created by ZH on 2017/3/29.
 */
public interface Cashier {

    void checkout(String username,List<String> isbns);
}
