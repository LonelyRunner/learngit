package com.finger.service.impl;

import com.finger.bean.Hero;
import com.finger.common.exception.DataAccessException;
import com.finger.common.exception.ServiceException;
import com.finger.common.transaction.HibernateTransaction;
import com.finger.common.util.DaoFactory;
import com.finger.common.util.HibernateSessionFactory;
import com.finger.dao.impl.HeroDaoImpl;
import com.finger.service.IHeroService;


import java.util.List;

/**
 * Created by ZH on 2016/7/21.
 */
public class HeroServiceImpl implements IHeroService {

    private HeroDaoImpl heroDao =
            (HeroDaoImpl)DaoFactory.getHeroDao();

    private HibernateTransaction hibernateTransaction =
            new HibernateTransaction();

    @Override
    public void saveHero(Hero hero) throws ServiceException {
        System.out.println(". . . Service - saveHero - begin . . .");
        try{
            heroDao.saveHero(hero);
            hibernateTransaction.commit();
            System.out.println(". . . Service - saveHero - success . . .");
        }catch(DataAccessException e){
            e.printStackTrace();
        }finally {
            HibernateSessionFactory.closeSession();
        }

    }

    @Override
    public void deleteHero(String heroName) throws ServiceException{
        System.out.println(". . . Service - deleteHero - begin . . .");
        try{
            heroDao.deleteHero(heroName);
            hibernateTransaction.commit();
            System.out.println(". . . Service - deleteHero - success . . .");
        }catch(DataAccessException e){
            e.printStackTrace();
        }finally {
            HibernateSessionFactory.closeSession();
        }
    }

    @Override
    public void updateHero(Hero newHero) throws ServiceException{
        System.out.println(". . . Service - updateHero - begin . . .");
        try {
            heroDao.updateHero(newHero);
            hibernateTransaction.commit();
            System.out.println(". . . Service - updateHero - success . . .");
        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            HibernateSessionFactory.closeSession();
        }
    }

    @Override
    public List<Hero> selectAllHeroes() throws ServiceException{
        System.out.println(". . . Service - selectAllHeroes - begin . . .");
        List<Hero> heroList = null;
        try {
            heroList = heroDao.selectAllHeroes();
            hibernateTransaction.commit();
            System.out.println(". . . Service - selectAllHeroes - success . . .");
        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            HibernateSessionFactory.closeSession();
        }
        return heroList;
    }

    @Override
    public Hero selectHeroByHeroName(String heroName) throws ServiceException{
        System.out.println(". . . Service - selectHeroByHeroName - begin . . .");
        Hero hero = null;
        try {
            hero = heroDao.selectHeroByHeroName(heroName);
            hibernateTransaction.commit();
            System.out.println(". . . Service - selectHeroByHeroName - success . . .");
        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            HibernateSessionFactory.closeSession();
        }
        return hero;
    }
}
