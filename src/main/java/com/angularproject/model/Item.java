package com.angularproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "items")
public class Item {

    @Id
    private String id;

    @Indexed
    private String name;

    private List<Stat> stats;

    // Default image stored in front app.
    private String image;

    // Image uploaded by client and stored in mongodb as Base64
    private String imageB64;
}
