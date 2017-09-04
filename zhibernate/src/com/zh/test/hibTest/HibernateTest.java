package com.zh.test.hibTest;

import com.zh.hib.pojo.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.sql.Date;


/**
 * Created by ZH on 2017/3/15.
 */
public class HibernateTest {

    @Test
    public void test(){

        //1). 创建Configuration对象:对应hibernate的配置信息和对象关系映射信息
        // Configuration configuration = new Configuration().configure();

        //hibernate4.0版本之前这么创建sessionFactory
        //sessionFactory = configuration.buildSessionFactory();

        //2). 创建一个ServiceRegistry对象:hibernate4.x 版本新增加的对象
        //hibernate的任何配置和服务都需要在该对象中注册才能生效
        //ServiceRegistry serviceRegistry =
                //new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        //5.0版本 ServiceRegistryBuilder --> StandardServiceRegistryBuilder

        //ServiceRegistry serviceRegistry =
        //            new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        //System.out.println(configuration.getProperties());

        // configures settings from hibernate.cfg.xml
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        //1. 创建sessionFactory对象

//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        //或者
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

//        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //创建一个Session对象
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //执行相关数据库操作 增、删、改、查
        News news = new News("javascript","郑豪",new Date(new java.util.Date().getTime()));
        session.save(news);
        //提交事务
        transaction.commit();
        //关闭session对象
        if(session != null){
            session.close();
        }
        //关闭sessionFactory对象
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
