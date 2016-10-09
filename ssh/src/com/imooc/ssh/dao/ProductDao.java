package com.imooc.ssh.dao;

import com.imooc.ssh.domain.Product;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *  数据持久层Dao
 */
public class ProductDao extends HibernateDaoSupport {

    public void saveProduct(Product product){
        System.out.println("ProductDao中的save方法执行了...");
        this.getHibernateTemplate().save(product);
    }
}

