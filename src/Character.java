import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by curtis on 8/5/17.
 */
public abstract class Character {

    private String name;
    private int maxHp;
    private int hp;
    private boolean blocking = false;
    private ImageIcon image;

    private Random random = new Random();

    public Character (String name, int hp, String image) {
          this.name = name;
          this.maxHp = hp;
          this.hp = hp;
        try {
            this.image = new ImageIcon(ImageIO.read(getClass().getResourceAsStream(image)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getImageIcon() {
        return image;
    }

    public boolean isDead () {
        return hp <= 0;
    }

    public void block () {
        blocking = true;
    }

    public void attack (int damage) {
        if (blocking) {
            blocking = false;
        } else {
            hp -= damage;
        }
    }

    public void magic (int damage) {
        if (blocking) {
            blocking = false;
        } else {
            hp -= damage;
        }
    }

    public int getDamage() {
        return random.nextInt(11) + 5; // 5-15
    }

    public void heal () {
        int healing = random.nextInt(10) + 1; // 1-10
        hp = Math.min(maxHp, hp + healing);
    }

    public void fullyHeal () {
        hp = maxHp;
    }

    public String toString () {
        if (isDead()) {
            return name + " (Dead)";
        } else {
            return name + " " + hp + "/" + maxHp;
        }
    }

}
