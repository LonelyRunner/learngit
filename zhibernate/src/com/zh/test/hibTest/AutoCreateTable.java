package com.zh.test.hibTest;

import com.zh.hib.pojo.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

/**
 * Test Hibernate auto create table.
 */
public class AutoCreateTable {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        sessionFactory =
                new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void testInsert(){
        News news = new News("java","郑豪",new Date(new java.util.Date().getTime()));
        session.persist(news);
    }

    @Test
    public void testFind(){
        News news = session.get(News.class,1);
        System.out.println(news);
    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
