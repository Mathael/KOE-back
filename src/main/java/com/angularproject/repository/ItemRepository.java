package com.angularproject.repository;

import com.angularproject.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Leboc Philippe.
 */
public interface ItemRepository extends MongoRepository<Item, String> {

}
