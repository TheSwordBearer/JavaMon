import java.io.IOException;

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

    public String getName () {
        return name;
    }

    public int getHp () {
        return hp;
    }

    public ImageIcon getImageIcon() {
        return image;
    }

    public boolean isAlive () {
        return hp > 0;
    }

    public void block () {
        blocking = true;
    }

    public void damage (int damage) {
        if (blocking) {
            blocking = false;
        } else {
            hp -= damage;
        }
    }

    public void heal (int healing) {
        hp = Math.min(maxHp, hp + healing);
    }

    public void fullyHeal () {
        hp = maxHp;
    }

    public String toString () {
        return name + " " + hp + "/" + maxHp;
    }

}
