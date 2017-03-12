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
@Document(collection = "heroes")
public class Hero {

    @Id
    private String id;
    @Indexed
    private String name;
    private String description;
    private String imageName;

    private List<Coordinate> movePattern;
    private List<Coordinate> attackPattern;
    private List<Coordinate> assistancePattern;

    private List<Stat> stats;

    public Hero(String name, String imageName, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern,  List<Stat> stats) {
        this(null, name, description, imageName, movePattern, attackPattern, assistancePattern, stats);
    }
}
