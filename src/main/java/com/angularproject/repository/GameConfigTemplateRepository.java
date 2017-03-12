package com.angularproject.repository;

import com.angularproject.model.GameConfigTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Leboc Philippe.
 */
public interface GameConfigTemplateRepository extends MongoRepository<GameConfigTemplate, String> {}
