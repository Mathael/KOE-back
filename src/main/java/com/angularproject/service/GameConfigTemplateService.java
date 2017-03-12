package com.angularproject.service;

import com.angularproject.model.GameConfigTemplate;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface GameConfigTemplateService {
    List<GameConfigTemplate> findAll();
    boolean update(GameConfigTemplate config);
    boolean delete(String id);
    GameConfigTemplate create(GameConfigTemplate config);
}
