import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
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
    private BattleGround battleGround = new BattleGround(this);
    private JLabel background = new JLabel();

    public JavaMon () {
        try {
            background.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("JavaMon.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(500,300);
        setTitle("JavaMon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buttons.add(Box.createGlue());
        buttons.add(start);
        buttons.add(exit);
        buttons.add(Box.createGlue());
        getContentPane().add(buttons, BorderLayout.SOUTH);
        getContentPane().add(background, BorderLayout.CENTER);
        setVisible(true);

    }

    private void startGame () {
        startAction.setEnabled(false);
        getContentPane().remove(background);
        getContentPane().add(battleGround, BorderLayout.CENTER);
        battleGround.startGame();
    }

    public void reset () {
        startAction.setEnabled(true);
    }

    public static void main (String[] args) {
        new JavaMon();
    }

}
