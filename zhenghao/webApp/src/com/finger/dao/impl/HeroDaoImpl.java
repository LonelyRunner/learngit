package com.finger.dao.impl;

import com.finger.bean.Hero;
import com.finger.common.exception.DataAccessException;
import com.finger.common.util.HibernateSessionFactory;
import com.finger.dao.IHeroDao;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zh
 * 2016-07-22
 */
public class HeroDaoImpl implements IHeroDao {

    /**
     * 保存一个Hero对象
     * @param hero
     * @throws DataAccessException
     */
    @Override
    public void saveHero(Hero hero) throws DataAccessException{
        System.out.println(". . . Dao - saveHero - begin . . .");
        Session session = HibernateSessionFactory.getSession();
        session.save(hero);
        System.out.println(". . . Dao -saveHero- success . . .");
    }

    /**
     * 根据HeroName来删除对应的Hero
     * @param heroName
     * @throws DataAccessException
     */
    @Override
    public void deleteHero(String heroName) throws DataAccessException{
        System.out.println(". . . Dao - deleteHero - begin . . .");
        Session session = HibernateSessionFactory.getSession();
        //先根据heroName获取Hero对象  然后直接调用Session自带方法删除
        Hero hero = (Hero)session.get(Hero.class,heroName);
        session.delete(hero);
        System.out.println(". . . Dao -deleteHero- success . . .");
    }

    /**
     * 更新
     * @param newHero
     * @throws DataAccessException
     */
    @Override
    public void updateHero(Hero newHero) throws DataAccessException{
        System.out.println(". . . Dao - updateHero - begin . . .");
        Session session = HibernateSessionFactory.getSession();
        session.saveOrUpdate(newHero);
        System.out.println(". . . Dao -updateHero- success . . .");
    }

    /**
     * 查询出所有对象
     * @throws DataAccessException
     */
    @Override
    public List<Hero> selectAllHeroes() throws DataAccessException{
        System.out.println(". . . Dao - selectAllHeroes - begin . . .");
        List<Hero> heroList = new ArrayList<>();
        Session session = HibernateSessionFactory.getSession();
        String hql = "from Hero";
        Query query = session.createQuery(hql);
        List list = query.list();
        for(Object o : list){
            Hero hero = (Hero) o ;
            heroList.add(hero);
        }
        System.out.println(". . . Dao -selectAllHeroes- success . . .");
        return heroList;
    }

    /**
     * 根据heroName查询出对应的Hero
     * @param heroName
     * @throws DataAccessException
     */
    @Override
    public Hero selectHeroByHeroName(String heroName) throws DataAccessException{
        System.out.println(". . . Dao -selectHeroByHeroName- success . . .");
        Session session = HibernateSessionFactory.getSession();
        String hql = "from Hero hero where hero.hero_name = ?";
        Query query = session.createQuery(hql);
        query.setString(0,heroName);
        List list = query.list();
        Hero hero = (Hero) list.get(0);
        System.out.println(". . . Dao -selectHeroByHeroName- success . . .");
        return hero;
    }
}
