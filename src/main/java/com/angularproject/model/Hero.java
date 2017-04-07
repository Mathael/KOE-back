package com.angularproject.model;

import com.angularproject.enums.Stats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    private String image; // Support for first run image & icon
    private String imageB64; // Uploaded images will be converted to base64
    private String iconB64; // Uploaded icon will be converted to base64

    private List<Coordinate> movePattern;
    private List<Coordinate> attackPattern;
    private List<Coordinate> assistancePattern;

    private List<Stat> stats;

    @DBRef
    private Item item;

    private double maxHp;
    private double maxMp;
    private double currentHp;
    private double currentMp;

    public Hero(String name, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern,  List<Stat> stats) {
        this(null, name, description, name.toLowerCase(), "", "", movePattern, attackPattern, assistancePattern, stats, null, 0, 0, 0, 0);
        final double hp = calcMaxHp();
        setMaxHp(hp);
        setCurrentHp(hp);
    }

    // Used to create a new Hero from front app
    public Hero(String name, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern,  List<Stat> stats, Item item) {
        this(null, name, description, name.toLowerCase(), "", "", movePattern, attackPattern, assistancePattern, stats, item, 0, 0, 0, 0);
        final double hp = calcMaxHp();
        setMaxHp(hp);
        setCurrentHp(hp);
    }

    public Hero(String name, String image, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern,  List<Stat> stats, Item item) {
        this(null, name, description, image, "", "", movePattern, attackPattern, assistancePattern, stats, item, 0, 0, 0, 0);
        final double hp = calcMaxHp();
        setMaxHp(hp);
        setCurrentHp(hp);
    }

    private double calcMaxHp() {
        return getStatValue(Stats.CON) * 10 + getStatValue(Stats.STR) * 2 - getStatValue(Stats.MEN);
    }

    private int getStatValue(Stats stat) {
        final Stat reqStat = getStats().stream().filter(s -> s.getSid().ordinal() == stat.ordinal()).findFirst().orElse(null);
        return reqStat != null ? reqStat.getValue() : 0;
    }
}
