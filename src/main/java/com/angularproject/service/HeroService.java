package com.angularproject.service;

import com.angularproject.model.Coordinate;
import com.angularproject.model.Hero;
import com.angularproject.model.Stat;

import java.util.List;
import java.util.Optional;

/**
 * @author Leboc Philippe.
 */
public interface HeroService {
    List<Hero> findAll();
    Optional<Hero> findById(String id);
    boolean update(Hero hero);
    boolean deleteHero(String id);
    Hero create(String name, String imageName, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern, List<Stat> stats);
    Hero create(Hero hero);
}
