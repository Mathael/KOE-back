package com.angularproject.controller;

import com.angularproject.model.Item;
import com.angularproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.PUT)
    public boolean updateItem(@RequestBody Item item) {
        Assert.notNull(item, "Object Item is null");
        return itemService.update(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteItem(@PathVariable(value = "id") String id) {
        Assert.hasLength(id, "Parameter id is null or empty");
        return itemService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item create(@RequestBody Item item) {
        Assert.notNull(item, "The item object is null");
        Assert.hasLength(item.getName(), "The item name is null or empty");
        return itemService.create(item);
    }
}
