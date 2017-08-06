import java.util.Random;

/**
 * Created by curtis on 8/5/17.
 */
public class Monster extends Character {

    private Random random = new Random();
    private String[] actions = new String[]{"Attack", "Heal", "Block"};

    public Monster (String name, int hp, String image) {
        super(name, hp, image);
    }

    public String pickAction () {
        return actions[random.nextInt(3)];
    }
}
