package com.angularproject.controller;

import com.angularproject.model.Item;
import com.angularproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
@RestController
@RequestMapping(value = "/item", produces = "application/json")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findAll() {
        return itemService.findAll();
    }
}
