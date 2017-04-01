package com.angularproject.model;

import com.angularproject.enums.Stats;
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

    private int getStatValue(Stats stat) {
        final Stat reqStat = getStats().stream().filter(s -> s.getSid().ordinal() == stat.ordinal()).findFirst().orElse(null);
        return reqStat != null ? reqStat.getValue() : 0;
    }
}
