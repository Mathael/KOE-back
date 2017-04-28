package com.angularproject.controller;

import com.angularproject.model.Hero;
import com.angularproject.model.Item;
import com.angularproject.service.HeroService;
import com.angularproject.service.ItemService;
import java.util.Base64;
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

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/hero/{heroId}/{type}", method = RequestMethod.POST)
    public Hero uploadHeroImage(@PathVariable("heroId") String entityId, @PathVariable("type") String type, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        Assert.hasLength(entityId, "heroId id is null or empty");
        Assert.notNull(multipartFile, "File is null");
        Assert.notNull(multipartFile.getBytes(), "File is null");

        final Optional<Hero> optionnal = heroService.findById(entityId);
        if(!optionnal.isPresent()) return null;

        final Hero hero = optionnal.get();

        if(type.equalsIgnoreCase("icon"))
            hero.setIconB64(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        else
            hero.setImageB64(Base64.getEncoder().encodeToString(multipartFile.getBytes()));

        heroService.update(hero);

        return hero;
    }

    @RequestMapping(value = "/item/{itemId}/{type}", method = RequestMethod.POST)
    public Item uploadItemImage(@PathVariable("itemId") String itemId, @PathVariable("type") String type, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        Assert.hasLength(itemId, "itemId id is null or empty");
        Assert.notNull(multipartFile, "File is null");
        Assert.notNull(multipartFile.getBytes(), "File is null");

        final Optional<Item> optionnal = itemService.findById(itemId);
        if(!optionnal.isPresent()) return null;

        final Item item = optionnal.get();

        item.setImageB64(Base64.getEncoder().encodeToString(multipartFile.getBytes()));

        itemService.update(item);

        return item;
    }
}
