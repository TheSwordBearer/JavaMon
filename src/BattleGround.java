import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by curtis on 8/5/17.
 */
public class BattleGround extends JPanel {

    private Image background;

    private JLabel heroHp = new JLabel();
    private JLabel monsterHp = new JLabel();

    public BattleGround () {
        setLayout(new BorderLayout());
        Box topBox = Box.createHorizontalBox();
        topBox.add(monsterHp);
        topBox.add(Box.createGlue());
        add(topBox, BorderLayout.NORTH);
        Box botBox = Box.createHorizontalBox();
        botBox.add(Box.createGlue());
        botBox.add(heroHp);
        add(botBox, BorderLayout.SOUTH);
        try {
            background = ImageIO.read(getClass().getResourceAsStream("JavaMon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public void setBattle (Battle battle) {
        heroHp.setText(battle.getHero().toString());
        monsterHp.setText(battle.getMonster().toString());
    }

}
