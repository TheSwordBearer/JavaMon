import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * JavaMon simple RPG
 */
public class JavaMon extends JFrame {

    private Action startAction = new AbstractAction("Start") {
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    };
    private Action exitAction = new AbstractAction("Exit") {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
    private JButton start = new JButton(startAction);
    private JButton exit = new JButton(exitAction);
    private Box buttons = Box.createHorizontalBox();
    private BattleGround battleGround = new BattleGround();

    public JavaMon () {
        setSize(640,480);
        setTitle("JavaMon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buttons.add(Box.createGlue());
        buttons.add(start);
        buttons.add(exit);
        buttons.add(Box.createGlue());
        getContentPane().add(buttons, BorderLayout.SOUTH);
        getContentPane().add(battleGround, BorderLayout.CENTER);
        setVisible(true);
    }

    private void startGame () {
        Hero hero = new Hero("Knight", 100);
        Monster monster = new Monster("Goblin Warrior", 20);
        Battle battle = new Battle(hero, monster);
        battleGround.setBattle(battle);
        Character winner = battle.battle();
        System.out.println(">> " + winner + " won the battle!");
    }

    public static void main (String[] args) {
        JavaMon frame = new JavaMon();
    }

}
