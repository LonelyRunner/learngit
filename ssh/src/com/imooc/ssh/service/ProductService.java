package com.imooc.ssh.service;

import com.imooc.ssh.dao.ProductDao;
import com.imooc.ssh.domain.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务逻辑层 Service
 */
@Transactional
public class ProductService{

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void saveProduct(Product product){
        System.out.println("ProductService中的save方法执行了...");
        this.productDao.saveProduct(product);
    }
}
