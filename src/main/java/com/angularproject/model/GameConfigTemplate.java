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
    private int maxHeroesPerTeam;

    public GameConfigTemplate(int maxHeroesPerTeam) {
        this(null, maxHeroesPerTeam);
    }
}
