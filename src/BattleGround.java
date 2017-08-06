import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Created by curtis on 8/5/17.
 */
public class BattleGround extends JPanel {

    private Hero hero = new Hero("Knight", 100, "knight.png");
    private Monster monster = null;
    private Monster goblin = new Monster("Goblin Warrior", 20, "goblin.png");
    private Monster mage = new Monster("Mage", 20, "mage.png");
    private Monster beholder = new Monster("Beholder", 40, "beholder.png");
    private Monster blackKnight = new Monster("Black Knight", 50, "black-knight.png");
    
    private JLabel heroLabel = new JLabel();
    private JLabel monsterLabel = new JLabel();

    private Action attackAction = new AbstractAction("Attack") {
        @Override
        public void actionPerformed(ActionEvent e) {
            takeTurn("Attack");
        }
    };
    private Action magicAction = new AbstractAction("Magic") {
        @Override
        public void actionPerformed(ActionEvent e) {
            takeTurn("Magic");
        }
    };
    private Action healAction = new AbstractAction("Heal") {
        @Override
        public void actionPerformed(ActionEvent e) {
            takeTurn("Heal");
        }
    };
    private Action blockAction = new AbstractAction("Block") {
        @Override
        public void actionPerformed(ActionEvent e) {
            takeTurn("Block");
        }
    };

    private JButton sword = new JButton(attackAction);
    private JButton magic = new JButton(magicAction);
    private JButton heal = new JButton(healAction);
    private JButton block = new JButton(blockAction);

    public BattleGround () {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        monsterLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        monsterLabel.setVerticalTextPosition(SwingConstants.TOP);
        heroLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        heroLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(monsterLabel, BorderLayout.WEST);
        add(heroLabel, BorderLayout.EAST);
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createGlue());
        buttonBox.add(sword);
        buttonBox.add(magic);
        buttonBox.add(heal);
        buttonBox.add(block);
        add(buttonBox, BorderLayout.SOUTH);
    }

    public void doBattle () {
        hero.fullyHeal();
        goblin.fullyHeal();
        mage.fullyHeal();
        beholder.fullyHeal();
        blackKnight.fullyHeal();
        monster = goblin;
        update();
    }

    private void update() {
        if (!monster.isAlive()) {
            nextMonster();
        }
        heroLabel.setIcon(hero.getImageIcon());
        heroLabel.setText(hero.toString());
        monsterLabel.setIcon(monster.getImageIcon());
        monsterLabel.setText(monster.toString());
    }

    private void nextMonster () {
        if (monster == goblin) {
            monster = mage;
        } else if (monster == mage) {
            monster = beholder;
        } else if (monster == beholder) {
            monster = blackKnight;
        }
    }

    private void doAction (Character actor, Character target, String action) {
        switch (action) {
            case "Attack": target.damage(10); break;
            case "Magic": target.damage(10); break;
            case "Heal": actor.heal(10); break;
            case "Block": actor.block(); break;
        }
        update();
    }

    private void takeTurn (String heroAction) {
        doAction(hero, monster, heroAction);
        doAction(monster, hero, monster.pickAction());
        update();
    }

}
