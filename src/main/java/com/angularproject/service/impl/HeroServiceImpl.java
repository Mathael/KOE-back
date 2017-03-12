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
        HEROES.add(new Hero("Aatrox", "aatrox", "Aatrox est un guerrier légendaire, l'un des cinq derniers survivants d'une race antique connue sous le nom de Darkin. Il porte sa large épée avec grâce et prestance, et se fraie un chemin dans les rangs ennemis dans un style hypnotisant.", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Ahri", "ahri", "Au contraire des autres renards qui parcourent les bois du Sud d'Ionia, Ahri avait toujours ressenti un lien étrange avec le monde magique qui l'entourait. Un lien qui pourtant lui semblait incomplet. Au plus profond d'elle-même, elle éprouvait le sentiment que son corps ne lui était pas adapté et elle rêvait de devenir un jour humaine.", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Ash", "ash", "Archère de Freljord", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Cassiopeia", "cassiopeia", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Diana", "diana", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Gnar", "gnar", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Janna", "janna", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Jarvan IV","jarvan", "", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Leona", "leona", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Lux", "lux", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Miss Fortune", "missfortune", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Nasus", "nasus", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Orianna", "orianna", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Renekton", "renekton", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Sona", "sona", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Sion", "sion", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Shyvana", "shyvana", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Teemo", "teemo", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Thresh", "thresh", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Vi", "vi", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Yi", "yi", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
        HEROES.add(new Hero("Zed", "zed", "Une autre description à faire", new ArrayList<>(), generateTemporaryMovePattern(), generateTemporaryAttackPattern(), getUniqStats()));
    }

    @PostConstruct
    public void init() {
        List<Hero> heroes = findAll();
        if(heroes.isEmpty()) {
            HEROES.forEach(hero -> this.create(hero.getName(), hero.getImageName(), hero.getDescription(), hero.getMovePattern(), hero.getAttackPattern(), hero.getAssistancePattern(), hero.getStats()));
            System.out.println(HEROES.size() + " are loaded.");
        } else {
            System.out.println(heroes.size() + " are loaded successful.");
        }
    }

    public List<Hero> findAll() {
        return heroRepository.findAll();
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

    public Hero create(String name, String imageName, String description, List<Coordinate> movePattern, List<Coordinate> attackPattern, List<Coordinate> assistancePattern, List<Stat> stats) {
        return heroRepository.insert(new Hero(name, imageName, description, movePattern, attackPattern, assistancePattern, stats));
    }

    private static List<Stat> getUniqStats() {
        final int health = Utils.getRandomNumberInRange(600, 1000);
        final int patk = Utils.getRandomNumberInRange(5, 10);
        final int pdef = Utils.getRandomNumberInRange(5, 10);
        final int matk = Utils.getRandomNumberInRange(5, 10);
        final int mdef = Utils.getRandomNumberInRange(5, 10);

        final List<Stat> stats = new ArrayList<>();
        stats.add(new Stat(Stats.HEALTH,"Points de vie", health));
        stats.add(new Stat(Stats.PATK,"Attaque physique", patk));
        stats.add(new Stat(Stats.MATK, "Attaque magique", matk));
        stats.add(new Stat(Stats.PDEF, "Défense physique", pdef));
        stats.add(new Stat(Stats.MDEF, "Défense magique", mdef));
        return stats;
    }

    private static List<Coordinate> generateTemporaryMovePattern() {
        final List<Coordinate> movePattern = new ArrayList<>();
        movePattern.add(new Coordinate(Utils.getRandomNumberInRange(1,3), 0));
        movePattern.add(new Coordinate(Utils.getRandomNumberInRange(1,3), 0));
        movePattern.add(new Coordinate(0, Utils.getRandomNumberInRange(1,3)));
        movePattern.add(new Coordinate(0, Utils.getRandomNumberInRange(1,3)));
        return movePattern;
    }

    private static List<Coordinate> generateTemporaryAttackPattern() {
        final List<Coordinate> attackPattern = new ArrayList<>();
        attackPattern.add(new Coordinate(0,1));
        attackPattern.add(new Coordinate(1,0));
        attackPattern.add(new Coordinate(0,-1));
        attackPattern.add(new Coordinate(-1,0));
        return attackPattern;
    }
}
