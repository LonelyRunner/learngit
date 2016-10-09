package com.zh.beanAnnotation.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by ZH on 2016/8/8.
 */
@Repository
public class BeanDaoImpl implements BeanDao{

    @Override
    public void save(String word) {
        System.out.println("dao:"+word.hashCode());
    }
}
