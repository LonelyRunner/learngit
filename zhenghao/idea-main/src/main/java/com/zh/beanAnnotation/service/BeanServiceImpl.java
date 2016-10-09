package com.zh.beanAnnotation.service;

import com.zh.beanAnnotation.dao.BeanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by ZH on 2016/8/8.
 */
@Service
public class BeanServiceImpl implements BeanService{

    //@Autowired
    private BeanDao beanDao;

    @Autowired
    public BeanServiceImpl(BeanDao beanDao){
        this.beanDao = beanDao;
    }

    //@Autowired
    public void setBeanDao(BeanDao beanDao){
        this.beanDao = beanDao;
    }

    @Override
    public void save(String word) {
        System.out.println("service : "+word);
        beanDao.save(word);
    }
}
