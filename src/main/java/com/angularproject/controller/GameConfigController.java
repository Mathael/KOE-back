package com.angularproject.controller;

import com.angularproject.model.GameConfigTemplate;
import com.angularproject.service.GameConfigTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/gameconfig", produces = "application/json")
public class GameConfigController {

    @Autowired
    private GameConfigTemplateService gameConfigTemplateService;

    @RequestMapping(method = RequestMethod.GET)
    public List<GameConfigTemplate> getGameConfigTemplates() {
        return gameConfigTemplateService.findAll();
    }
}
