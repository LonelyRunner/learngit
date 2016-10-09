package com.finger.dao;

import com.finger.bean.Hero;
import com.finger.common.exception.DataAccessException;

import java.util.List;

/**
 * Created by ZH on 2016/7/21.
 */
public interface IHeroDao {

    void saveHero(Hero hero) throws DataAccessException;

    void deleteHero(String heroName) throws DataAccessException;

    void updateHero(Hero newHero) throws DataAccessException;

    List<Hero> selectAllHeroes() throws DataAccessException;

    Hero selectHeroByHeroName(String heroName) throws DataAccessException;
}
