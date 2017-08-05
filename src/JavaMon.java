import javax.swing.*;

/**
 * JavaMon simple RPG
 */
public class JavaMon extends JFrame {

    public JavaMon () {
        setSize(500,500);
        setTitle("JavaMon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main (String[] args) {
        JavaMon frame = new JavaMon();
    }

}
