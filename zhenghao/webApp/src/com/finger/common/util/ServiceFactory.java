package com.finger.common.util;

import com.finger.service.IHeroService;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ZH on 2016/7/21.
 */
public class ServiceFactory {

    public static Properties getProperties(){
        Properties properties = new Properties();
        try{
            properties.load(ServiceFactory.class.getClassLoader().getResourceAsStream("com/finger/ApplicationResource.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    public static IHeroService getHeroService(){
        IHeroService heroService = null;
        Properties properties = getProperties();
        String className = properties.getProperty("HeroServiceImpl");
        try{
            heroService = (IHeroService)Class.forName(className).newInstance();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return heroService;
    }
}
