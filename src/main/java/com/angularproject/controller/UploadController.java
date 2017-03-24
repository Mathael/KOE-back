package com.angularproject.controller;

import com.angularproject.model.Hero;
import com.angularproject.service.HeroService;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Leboc Philippe.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/upload", produces = "application/json")
public class UploadController {

    @Autowired
    private HeroService heroService;

    @RequestMapping(value = "/{heroId}/{type}", method = RequestMethod.POST)
    public Hero uploadFile(@PathVariable("heroId") String heroId, @PathVariable("type") String type, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        Assert.hasLength(heroId, "Hero id is null or empty");
        Assert.notNull(multipartFile, "File is null");
        Assert.notNull(multipartFile.getBytes(), "File is null");

        final Optional<Hero> heroOpt = heroService.findById(heroId);
        if(!heroOpt.isPresent()) return null;

        final Hero hero = heroOpt.get();

        if(type.equalsIgnoreCase("icon"))
            hero.setIconB64(Base64.encode(multipartFile.getBytes()));
        else
            hero.setImageB64(Base64.encode(multipartFile.getBytes()));

        heroService.update(hero);

        return hero;
    }
}
