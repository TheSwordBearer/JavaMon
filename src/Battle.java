import java.util.Random;

/**
 * Created by curtis on 8/5/17.
 */
public class Battle {

    private Hero hero;
    private Monster monster;
    private Random rnd = new Random();

    public Battle (Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public Character battle () {
        while (hero.isAlive() && monster.isAlive()) {
            monster.heal(healAmount());
            if (hero.isAlive()) {
                monster.damage(attackDamage());
            }
            hero.heal(healAmount());
            if (monster.isAlive()) {
                hero.damage(attackDamage());
            }
        }
        return hero.isAlive() ? hero : monster;
    }

    private int attackDamage () {
        return rnd.nextInt(10);
    }

    private int healAmount () {
        return rnd.nextInt(5);
    }

}
