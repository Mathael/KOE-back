package com.angularproject.service.impl;

import com.angularproject.model.GameConfigTemplate;
import com.angularproject.repository.GameConfigTemplateRepository;
import com.angularproject.service.GameConfigTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
@Service
public class GameConfigTemplateServiceImpl implements GameConfigTemplateService {

    @Autowired
    private GameConfigTemplateRepository gameConfigTemplateRepository;

    private static final List<GameConfigTemplate> TEMPLATES = new ArrayList<>();
    static
    {
        TEMPLATES.add(new GameConfigTemplate("Très rapide", 3));
        TEMPLATES.add(new GameConfigTemplate("Rapide", 5));
        TEMPLATES.add(new GameConfigTemplate("Normal", 8));
        TEMPLATES.add(new GameConfigTemplate("Lent", 10));
        TEMPLATES.add(new GameConfigTemplate("Très lent", 12));
    }

    @PostConstruct
    public void init() {
        List<GameConfigTemplate> heroes = findAll();
        if(heroes.isEmpty()) {
            TEMPLATES.forEach(this::create);
            System.out.println(TEMPLATES.size() + " game config loaded");
        } else {
            System.out.println(heroes.size() + " game config loaded");
        }
    }

    public List<GameConfigTemplate> findAll() {
        return gameConfigTemplateRepository.findAll();
    }

    public boolean update(GameConfigTemplate config) {
        if(config == null || config.getId() == null) return false;
        gameConfigTemplateRepository.save(config);
        return true;
    }

    @Override
    public boolean delete(String id) {
        if(!gameConfigTemplateRepository.exists(id)) return false;
        gameConfigTemplateRepository.delete(id);
        return true;
    }

    public GameConfigTemplate create(GameConfigTemplate config) {
        return gameConfigTemplateRepository.insert(config);
    }
}
