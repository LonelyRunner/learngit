package com.zh.txxml.Service;

import com.zh.txxml.dao.BookShopDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    //添加事务注解
    //1.使用 propagation 指定事务的传播行为, 即当前的事务方法被另外一个事务方法调用时
    //如何使用事务, 默认取值为 REQUIRED, 即使用调用方法的事务
    //REQUIRES_NEW: 事务自己的事务, 调用的事务方法的事务被挂起.
    //2.使用 isolation 指定事务的隔离级别, 最常用的取值为 READ_COMMITTED
    //3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚. 也可以通过对应的
    //属性进行设置. 通常情况下去默认值即可.
    //4.使用 readOnly 指定事务是否为只读. 表示这个事务只读取数据但不更新数据,
    //这样可以帮助数据库引擎优化事务. 若真的事一个只读取数据库值的方法, 应设置 readOnly=true
    //5.使用 timeout 指定强制回滚之前事务可以占用的时间.

    /**
     * 未添加transaction注解时:当余额不足时，或者违反数据库检查约束是  会抛出异常
     *            此时余额没有发生变化  但是库存量已经减去1
     *            所有就涉及到了事务的问题
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void purchase(String username, String isbn) {

        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新库存
        bookShopDao.updateBookStock(isbn);

        //更新账户余额
        bookShopDao.updateUserAccount(username,price);
    }
}
