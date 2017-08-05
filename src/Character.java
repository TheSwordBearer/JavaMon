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
        System.out.println(name + " hp " + hp);
        hp -= damage;
    }

    public void heal (int healing) {
        System.out.println(name + " hp " + hp);
        hp += healing;
    }

}
