package com.angularproject.service.impl;

import com.angularproject.enums.Stats;
import com.angularproject.model.Item;
import com.angularproject.model.Stat;
import com.angularproject.repository.ItemRepository;
import com.angularproject.service.ItemService;
import com.angularproject.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Leboc Philippe.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private static final List<Item> ITEMS = new ArrayList();
    static
    {
        ITEMS.add(new Item(null, "AAAA", getUniqStats()));
        ITEMS.add(new Item(null, "BBBB", getUniqStats()));
        ITEMS.add(new Item(null, "CCCC", getUniqStats()));
        ITEMS.add(new Item(null, "DDDD", getUniqStats()));
        ITEMS.add(new Item(null, "EEEE", getUniqStats()));
    }

    @PostConstruct
    public void init() {
        List<Item> items = findAll();
        if(items.isEmpty()) {
            ITEMS.forEach(this::create);
            System.out.println(ITEMS.size() + " are loaded.");
        } else {
            System.out.println(items.size() + " are loaded successful.");
        }
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(String id) {
        return itemRepository.findOne(id);
    }

    @Override
    public boolean update(Item item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        itemRepository.delete(id);
        return true;
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    private static List<Stat> getUniqStats() {
        final int str = Utils.getRandomNumberInRange(1, 15);
        final List<Stat> stats = new ArrayList<>();
        stats.add(new Stat(Stats.STR,"Force physique", str));
        return stats;
    }
}
