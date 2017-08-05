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
            System.out.println("Starting...");
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

    public JavaMon () {
        setSize(500,500);
        setTitle("JavaMon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buttons.add(Box.createGlue());
        buttons.add(start);
        buttons.add(exit);
        getContentPane().add(buttons, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main (String[] args) {
        JavaMon frame = new JavaMon();
    }

}
