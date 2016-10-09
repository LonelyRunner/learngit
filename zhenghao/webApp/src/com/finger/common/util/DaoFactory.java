package com.finger.common.util;

import com.finger.dao.IHeroDao;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ZH on 2016/7/21.
 */
public class DaoFactory {

    public static Properties getProperties(){
        Properties properties = new Properties();
        try{
            properties.load(DaoFactory.class.getResourceAsStream("../../ApplicationResource.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    public static IHeroDao getHeroDao(){
        IHeroDao heroDao = null;
        Properties properties = getProperties();
        String className = properties.getProperty("HeroDaoImpl");
        try{
            heroDao = (IHeroDao) Class.forName(className).newInstance();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return heroDao;
    }
}
