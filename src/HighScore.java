import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class HighScore extends JFrame {

    public HighScore(int width, int height){

        setSize(width, height);
        setTitle("Duck Shooter");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        JLabel menuLabel = new JLabel("High Scores:");
        menuLabel.setFont(new FontUIResource("Times New Roman", Font.BOLD ,30));

        JPanel menu = new JPanel(){};
//        JList highscore = new JList(playerArrayList.toArray());
        menu.setLayout(new ScrollPaneLayout());
        menu.add(menuLabel);

        menu.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createHorizontalGlue());
        getContentPane().add(menu);
        add(Box.createHorizontalGlue());
    }
}
