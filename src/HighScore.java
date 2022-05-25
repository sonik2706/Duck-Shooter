import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScore extends JFrame {

    public HighScore(int width, int height){

        setSize(width, height);
        setTitle("Duck Shooter");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().setBackground(new java.awt.Color(204, 255, 255));

        ScoreList scoreList = new ScoreList();
        JList jList = new JList(scoreList);

        JScrollPane jScrollPane = new JScrollPane(jList);
        add(jScrollPane);

        JButton backToMenu = new JButton("Back");
        backToMenu.setFont(new FontUIResource("Times New Roman", Font.PLAIN, 25));
        backToMenu.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new Menu(width, height);
            });
        });

        add(backToMenu);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jScrollPane);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);


        add(Box.createHorizontalGlue());
        getContentPane().add(panel);
        add(Box.createHorizontalGlue());
    }
}
