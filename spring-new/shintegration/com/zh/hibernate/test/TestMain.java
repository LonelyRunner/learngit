package com.zh.hibernate.test;

import com.zh.hibernate.dao.BookShopDao;
import com.zh.hibernate.service.BookShopService;
import com.zh.hibernate.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestMain {

    private ApplicationContext ctx;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = (BookShopDao)ctx.getBean("bookShopDao");
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = (Cashier) ctx.getBean("cashier");
    }

    /**
     * 插入测试数据
     */
    @Test
    public void insertTestData(){
        bookShopDao.testInsertData();
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn(){
        int price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println("The book's price is $"+price);
    }

    @Test
    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("1002");
        System.out.println("更新成功~~~");
    }

    @Test
    public void testBookShopDaoUpdateAccount(){
        bookShopDao.updateAccount("jack",200);
    }

    @Test
    public void testBookService(){
        bookShopService.purchase("tom","1001");
    }

    @Test
    public void testCashier(){
        cashier.checkout("tom", Arrays.asList("1001","1002","1004"));
    }
}
