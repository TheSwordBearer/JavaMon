import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Created by curtis on 8/5/17.
 */
public class BattleGround extends JPanel {

    private JavaMon game;

    private Hero hero = new Hero("Knight", 50, "knight.png");
    private Monster goblin = new Monster("Goblin Warrior", 20, "goblin.png");
    private Monster mage = new Monster("Mage", 20, "mage.png");
    private Monster beholder = new Monster("Beholder", 40, "beholder.png");
    private Monster blackKnight = new Monster("Black Knight", 50, "black-knight.png");
    private Monster monster = null;

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

    public BattleGround (JavaMon game) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        this.game = game;
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

    public void startGame() {
        attackAction.setEnabled(true);
        magicAction.setEnabled(true);
        healAction.setEnabled(true);
        blockAction.setEnabled(true);
        hero.fullyHeal();
        goblin.fullyHeal();
        mage.fullyHeal();
        beholder.fullyHeal();
        blackKnight.fullyHeal();
        monster = goblin;
        update();
    }

    private void update() {
        if (monster.isDead()) {
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
            case "Attack": target.attack(actor.getDamage()); break;
            case "Magic": target.magic(actor.getDamage()); break;
            case "Heal": actor.heal(); break;
            case "Block": actor.block(); break;
        }
        update();
    }

    private void takeTurn (String heroAction) {
        doAction(hero, monster, heroAction);
        update();
        checkWin();
        String monsterAction = monster.pickAction();
        doAction(monster, hero, monsterAction);
        update();
        checkLose();
    }

    private void checkWin() {
        if (blackKnight.isDead()) {
            JOptionPane.showMessageDialog(this, "You Won!!");
            reset();
        }
    }

    private void checkLose() {
        if (hero.isDead()) {
            JOptionPane.showMessageDialog(this, "You Lose!!");
            reset();
        }
    }

    private void reset () {
        attackAction.setEnabled(false);
        magicAction.setEnabled(false);
        healAction.setEnabled(false);
        blockAction.setEnabled(false);
        game.reset();
    }

}
