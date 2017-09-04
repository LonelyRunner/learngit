package com.zh.hibernate.dao.impl;

import com.zh.hibernate.dao.BookShopDao;
import com.zh.hibernate.entity.Account;
import com.zh.hibernate.entity.Book;
import com.zh.hibernate.exceptions.AccountException;
import com.zh.hibernate.exceptions.BookStockException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的session
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String hql = "select b.price from Book b where b.isbn=?";
        Query query = getSession().createQuery(hql).setString(0,isbn);
        return (Integer)query.uniqueResult();
    }

    @Override
    public void updateBookStock(String isbn) {
        //检查库存是否为0
        String stockHql = "select b.stock from Book b where b.isbn = ?";
        int stock = (Integer)getSession().createQuery(stockHql).setString(0,isbn).uniqueResult();
        if(stock==0){
            throw new BookStockException("库存不足~~~");
        }else{
            String updateStockSql = "update Book b set b.stock = b.stock-1 where b.isbn=?";
            getSession().createQuery(updateStockSql).setString(0,isbn).executeUpdate();
        }
    }

    @Override
    public void updateAccount(String username, int price) {
        //检查月是否足够
        String accountHql = "select a.balance from Account a where a.username=?";
        int balance = (Integer)getSession().createQuery(accountHql).setString(0,username).uniqueResult();
        if(balance<price){
            throw new AccountException("余额不足~~~");
        }else{
            String updateAccountHql = "update Account a set a.balance=a.balance-? where a.username=?";
            getSession().createQuery(updateAccountHql).setInteger(0,price).setString(1,username).executeUpdate();
        }
    }

    @Transactional
    public void testInsertData(){
        Book book1 = new Book("java","1001",80,10);
        Book book2 = new Book("oracle","1002",100,6);
        Book book3 = new Book("c#","1003",120,4);
        Book book4 = new Book("php","1004",140,3);
        Book book5 = new Book("C++","1005",160,7);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        for(Book book : bookList){
            getSession().persist(book);
        }

        Account account1 = new Account("tom",1000);
        Account account2 = new Account("jack",1200);
        Account account3 = new Account("Lily",1300);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        for(Account account : accountList){
            getSession().persist(account);
        }
    }
}
