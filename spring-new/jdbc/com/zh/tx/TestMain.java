package com.zh.tx;

import com.zh.tx.Service.BookShopService;
import com.zh.tx.Service.Cashier;
import com.zh.tx.dao.BookShopDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by ZH on 2017/3/29.
 */
public class TestMain {

    private ApplicationContext ctx;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext-tx.xml");
        bookShopDao = (BookShopDao)ctx.getBean("bookShopDao");
        bookShopService = (BookShopService)ctx.getBean("bookShopService");
        cashier = ctx.getBean(Cashier.class);
    }

    /**
     * ����isbn��ѯͼ��۸�
     */
    @Test
    public void testBookShopDaoFindPriceByIsbn(){
        String isbn = "1001";
        int price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println("Book "+ isbn +"'s price is $"+price+".");
    }

    /**
     * ����ͼ��Ŀ������
     */
    @Test
    public void testBookShopDaoUpdateBookStock(){
        String isbn = "1001";
        bookShopDao.updateBookStock(isbn);
        System.out.println("Book "+isbn+"'s stock had sub one.");
    }

    /**
     * �����û����˻����
     */
    @Test
    public void testBookShopDaoUpdateAccount(){
        String username = "tom";
        int price = 100;
        bookShopDao.updateUserAccount(username,price);
        System.out.println(username+"���˻��Ѹ���.");
    }


    /**
     * test bookShopService
     */
    @Test
    public void testBookShopServicePurchase(){
        bookShopService.purchase("tom","1001");
    }

    /**
     * test Cashier
     */
    @Test
    public void testCashier(){
        cashier.checkout("tom", Arrays.asList("1001","1002"));
    }
}
