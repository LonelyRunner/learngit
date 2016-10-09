package com.imooc.ssh.action;

import com.imooc.ssh.domain.Product;
import com.imooc.ssh.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by ZH on 2016/8/25.
 */
public class ProductAction extends ActionSupport implements ModelDriven{

    private ProductService productService;
    private Product product = new Product();

    @Override
    public Object getModel() {
        return product;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public String saveProduct(Product product){
        System.out.println("ProductAction中的save方法执行了...");
        productService.saveProduct(product);
        return NONE;
    }
}
