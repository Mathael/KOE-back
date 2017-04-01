package com.angularproject.service;

import com.angularproject.model.Item;

import java.util.List;
import java.util.Optional;

/**
 * @author Leboc Philippe.
 */
public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(String id);
    boolean update(Item item);
    boolean delete(String id);
    Item create(Item item);
}
