package com.zh.service;

import com.zh.dao.InjectionDao;

/**
 * Created by ZH on 2016/7/12.
 */
public class InjectionServiceImpl implements InjectionService{
    private InjectionDao injectionDao;

    public InjectionServiceImpl(InjectionDao injectionDao){
        this.injectionDao = injectionDao;
    }

    public void setInjectionDao(InjectionDao injectionDao){
        this.injectionDao = injectionDao;
    }

    public void sayHello(String str){
        System.out.println("service : hello,"+str);
        str = str+":"+str.hashCode();
        injectionDao.hello(str);
    }
}
