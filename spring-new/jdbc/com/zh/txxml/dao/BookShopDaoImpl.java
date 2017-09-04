package com.zh.txxml.dao;

import com.zh.txxml.exception.BookShopDaoException;
import com.zh.txxml.exception.UserAccountException;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";
        int result = jdbcTemplate.queryForObject(sql,Integer.class,isbn);
        return result;
    }

    @Override
    public void updateBookStock(String isbn) {
        String stockSql = "select stock from book_stock where isbn=?";
        int stock = jdbcTemplate.queryForObject(stockSql,Integer.class,isbn);

        if(stock==0){
            throw new BookShopDaoException("库存不足~~~");
        }else{
            String sql = "update book_stock set stock=stock-1 where isbn=?";
            int i = jdbcTemplate.update(sql,isbn);
            if(i>0){
                System.out.println("更新成功~~~");
            }else{
                System.out.println("更新失败~~~");
            }
        }
    }

    @Override
    public void updateUserAccount(String username, int price) {
        String balanceSql = "select balance from account where username=?";
        int balance = jdbcTemplate.queryForObject(balanceSql,Integer.class,username);
        if(balance<price){
            throw new UserAccountException("用户余额不足~~~");
        }else{
            String sql = "update account set balance=balance-? where username=?";
            int i = jdbcTemplate.update(sql,price,username);
            if(i>0){
                System.out.println("更新成功~~~");
            }else{
                System.out.println("更新失败~~~");
            }
        }
    }
}
