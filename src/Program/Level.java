package Program;

import javax.swing.*;
import java.io.IOException;

public class Level extends JFrame {
    int level;

    public Level() {
        setSize(300 , 100);
        setTitle("Level");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel jPanel = new JPanel();

        JButton easy = new JButton("Easy");
        easy.addActionListener(arg0 -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                try {
                    new NewGame(1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        JButton medium = new JButton("Medium");
        medium.addActionListener(arg0 -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                try {
                    new NewGame(2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        JButton hard = new JButton("Hard");
        hard.addActionListener(arg0 -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                try {
                    new NewGame(3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        jPanel.add(easy);
        jPanel.add(medium);
        jPanel.add(hard);
        add(jPanel);
    }
}
