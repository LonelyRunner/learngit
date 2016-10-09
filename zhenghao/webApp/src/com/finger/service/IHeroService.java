package com.finger.service;

import com.finger.bean.Hero;
import com.finger.common.exception.ServiceException;
import java.util.List;

/**
 * Created by ZH on 2016/7/21.
 */
public interface IHeroService {

    void saveHero(Hero hero) throws ServiceException;

    void deleteHero(String heroName) throws ServiceException;

    void updateHero(Hero newHero) throws ServiceException;

    List<Hero> selectAllHeroes() throws ServiceException;

    Hero selectHeroByHeroName(String heroName) throws ServiceException;
}
