package com.angularproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author Leboc Philippe.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameConfigTemplate {

    @Id
    private String id;
    private String name;
    private int maxHeroesPerTeam;

    public GameConfigTemplate(String name, int maxHeroesPerTeam) {
        this(null, name, maxHeroesPerTeam);
    }
}
