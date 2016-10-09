package com.finger.web.servlet;

import com.finger.bean.Hero;
import com.finger.common.exception.ServiceException;
import com.finger.common.util.ServiceFactory;
import com.finger.service.impl.HeroServiceImpl;

import java.util.List;

/**
 * Created by ZH on 2016/7/22.
 */
public class EasyTest {

    private HeroServiceImpl heroService =
            (HeroServiceImpl)ServiceFactory.getHeroService();

    public void saveHero(Hero hero){
        try{
            heroService.saveHero(hero);
        }catch(ServiceException e){
            e.printStackTrace();
        }
    }

    public List<Hero> getAllHeroes(){
        List<Hero> list = null;
        try{
            list = heroService.selectAllHeroes();
        }catch(ServiceException e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String args[]){
        EasyTest test = new EasyTest();
//        Hero hero = new Hero();
//        hero.setHero_name("潮汐海灵");
//        hero.setHero_Q("淘气打击");
//        hero.setHero_W("海石三叉戟");
//        hero.setHero_E("古灵精怪");
//        hero.setHero_R("巨鲨强袭");
//        hero.setHero_passive("伶俐斗士");
//        hero.setHero_img("../../fish.img");
//        test.saveHero(hero);

        List<Hero> list = test.getAllHeroes();
        for(Hero hero : list){
            System.out.println(hero);
        }
    }
}
