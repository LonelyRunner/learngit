package com.finger.common.transaction;

import com.finger.common.util.HibernateSessionFactory;
import org.hibernate.Session;

/**
 * Created by ZH on 2016/7/21.
 */
public class HibernateTransaction implements Transaction {

    private org.hibernate.Transaction transaction;

    @Override
    public void beginTransaction() {
        Session session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
    }

    @Override
    public void commit() {
        transaction.commit();
    }

    @Override
    public void rollback() {
        transaction.rollback();
    }
}
