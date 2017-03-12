package com.angularproject.repository;

import com.angularproject.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Leboc Philippe.
 */
public interface HeroRepository extends MongoRepository<Hero, String> {}
