import java.awt.*;

import javax.swing.*;

/**
 * Created by curtis on 8/5/17.
 */
public class BattleGround extends JPanel {

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
    }

    public void setBattle (Battle battle) {
        heroHp.setText(battle.getHero().toString());
        monsterHp.setText(battle.getMonster().toString());
    }

}
