package com.angularproject.controller;

import com.angularproject.model.Hero;
import com.angularproject.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/hero", produces = "application/json")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Hero> getHeroes() {
        return heroService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public boolean updateHero(@RequestBody Hero hero) {
        Assert.notNull(hero, "Object Hero is null");
        return heroService.update(hero);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteHero(@PathVariable(value = "id") String id) {
        Assert.hasLength(id, "Parameter id is null or empty");
        return heroService.deleteHero(id);
    }
}
