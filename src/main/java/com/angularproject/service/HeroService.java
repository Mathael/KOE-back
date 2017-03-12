package com.angularproject.service;

import com.angularproject.model.Coordinate;
import com.angularproject.model.Hero;
import com.angularproject.model.Stat;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface HeroService {
    List<Hero> findAll();
    boolean update(Hero hero);
    boolean deleteHero(String id);
    Hero create(String name, String imageName, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern, List<Stat> stats);
}
