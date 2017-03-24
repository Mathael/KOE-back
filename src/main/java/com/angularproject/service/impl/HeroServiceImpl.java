package com.angularproject.service.impl;

import com.angularproject.enums.Stats;
import com.angularproject.model.Hero;
import com.angularproject.model.Coordinate;
import com.angularproject.model.Stat;
import com.angularproject.repository.HeroRepository;
import com.angularproject.service.HeroService;
import com.angularproject.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    private static final List<Hero> HEROES = new ArrayList();
    static
    {
        final List<Coordinate> pattern = generateTemporaryPattern();
        HEROES.add(new Hero("Aatrox", "aatrox", "Aatrox est un guerrier légendaire, l'un des cinq derniers survivants d'une race antique connue sous le nom de Darkin. Il porte sa large épée avec grâce et prestance, et se fraie un chemin dans les rangs ennemis dans un style hypnotisant.", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Ahri", "ahri", "Au contraire des autres renards qui parcourent les bois du Sud d'Ionia, Ahri avait toujours ressenti un lien étrange avec le monde magique qui l'entourait. Un lien qui pourtant lui semblait incomplet. Au plus profond d'elle-même, elle éprouvait le sentiment que son corps ne lui était pas adapté et elle rêvait de devenir un jour humaine.", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Ash", "ash", "Archère de Freljord", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Cassiopeia", "cassiopeia", "Une autre description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Diana", "diana", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Gnar", "gnar", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Janna", "janna", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Jarvan IV","jarvan", "", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Leona", "leona", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Lux", "lux", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Miss Fortune", "missfortune", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Nasus", "nasus", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Orianna", "orianna", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Renekton", "renekton", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Sona", "sona", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Sion", "sion", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Shyvana", "shyvana", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Teemo", "teemo", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Thresh", "thresh", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Vi", "vi", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Yi", "yi", "Description à faire", pattern, pattern, pattern, getUniqStats()));
        HEROES.add(new Hero("Zed", "zed", "Description à faire", pattern, pattern, pattern, getUniqStats()));
    }

    @PostConstruct
    public void init() {
        List<Hero> heroes = findAll();
        if(heroes.isEmpty()) {
            HEROES.forEach(hero -> this.create(hero.getName(), hero.getImage(), hero.getDescription(), hero.getMovePattern(), hero.getAttackPattern(), hero.getAssistancePattern(), hero.getStats()));
            System.out.println(HEROES.size() + " are loaded.");
        } else {
            System.out.println(heroes.size() + " are loaded successful.");
        }
    }

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Hero findById(String id) {
        return heroRepository.findOne(id);
    }

    public boolean update(Hero hero) {
        if(hero == null || hero.getId() == null) return false;
        heroRepository.save(hero);
        return true;
    }

    @Override
    public boolean deleteHero(String id) {
        if(!heroRepository.exists(id)) return false;
        heroRepository.delete(id);
        return true;
    }

    @Override
    public Hero create(String name, String imageName, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern, List<Stat> stats) {
        return heroRepository.insert(new Hero(name, imageName, description, movePattern, attackPattern, assistancePattern, stats));
    }

    @Override
    public Hero create(final Hero hero) {
        return heroRepository.insert(hero);
    }

    private static List<Stat> getUniqStats() {
        final int str = Utils.getRandomNumberInRange(1, 20);
        final int con = Utils.getRandomNumberInRange(1, 40-str-3);
        final int dex = Utils.getRandomNumberInRange(1, 40-str-con-2);
        final int intel = Utils.getRandomNumberInRange(1, 40-str-con-dex-1);
        final int men = Utils.getRandomNumberInRange(1, 40-str-con-dex-intel);

        final List<Stat> stats = new ArrayList<>();
        stats.add(new Stat(Stats.STR,"Force physique", str));
        stats.add(new Stat(Stats.CON,"Constitution", con));
        stats.add(new Stat(Stats.DEX, "Dextérité", dex));
        stats.add(new Stat(Stats.INT, "Intelligence", intel));
        stats.add(new Stat(Stats.MEN, "Mental", men));
        return stats;
    }

    private static List<Coordinate> generateTemporaryPattern() {
        final List<Coordinate> attackPattern = new ArrayList<>();
        attackPattern.add(new Coordinate(0,1));
        attackPattern.add(new Coordinate(1,0));
        attackPattern.add(new Coordinate(0,-1));
        attackPattern.add(new Coordinate(-1,0));
        return attackPattern;
    }
}
