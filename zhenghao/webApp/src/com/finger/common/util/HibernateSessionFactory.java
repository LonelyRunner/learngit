package com.finger.common.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by ZH on 2016/7/19.
 */
public class HibernateSessionFactory {
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;

    private HibernateSessionFactory(){

    }

    /**
     *
     * @return Session
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException{
        Session session = threadLocal.get();
        if(session==null || !session.isOpen()){
            if(sessionFactory==null){
                rebuildSessionFactory();
            }
            session = (sessionFactory!=null)?sessionFactory.openSession():null;
            threadLocal.set(session);
        }
        return session;
    }

    public static void rebuildSessionFactory(){
        try{
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        }catch(Exception e){
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException{
        Session session = threadLocal.get();
        threadLocal.set(null);
        if(session!=null){
            session.close();
        }
    }

    /**
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    /**
     *
     * @param configFile
     */
    public static void setConfigFile(String configFile){
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }

    /**
     * @return Configuration
     */
    public static Configuration getConfiguration(){
        return configuration;
    }
}
