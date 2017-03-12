package com.angularproject.model;

import com.angularproject.enums.Stats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leboc Philippe.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    private Stats sid;
    private String label;
    private int value;
}
