/**
 * Created by curtis on 8/5/17.
 */
public abstract class Character {

    private int hp;
    private String name;

    public Character (String name, int hp) {
          this.name = name;
          this.hp = hp;
    }

    public String getName () {
        return name;
    }

    public int getHp () {
        return hp;
    }

    public boolean isAlive () {
        return hp > 0;
    }

    public void damage (int damage) {
        hp -= damage;
        System.out.println(name + " hp " + hp);
    }

    public void heal (int healing) {
        hp += healing;
        System.out.println(name + " hp " + hp);
    }

    public String toString () {
        return name + "(" + hp + ")";
    }

}
