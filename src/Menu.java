import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;

public class Menu extends JFrame {

    public Menu(int width, int height) {

        setSize(width, height);
        setTitle("Duck Shooter");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        JLabel menuLabel = new JLabel("MENU");
        menuLabel.setFont(new FontUIResource("Times New Roman", Font.BOLD, 30));

        // New game button
        JButton newGameButton = new JButton("NEW GAME");
        newGameButton.setFont(new FontUIResource("Times New Roman", Font.PLAIN, 25));
        newGameButton.setContentAreaFilled(false);
        newGameButton.setBorder(BorderFactory.createEmptyBorder());
        newGameButton.addActionListener(arg0 -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                try {
                    new NewGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        // Highscore button
        JButton highScoreButton = new JButton("HIGH SCORES");
        highScoreButton.setFont(new FontUIResource("Times New Roman", Font.PLAIN, 25));
        highScoreButton.setContentAreaFilled(false);
        highScoreButton.setBorder(BorderFactory.createEmptyBorder());
        highScoreButton.addActionListener(arg0 -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new HighScore(width, height);
            });
        });

        // Exit button
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new FontUIResource("Times New Roman", Font.PLAIN, 25));
        exitButton.setContentAreaFilled(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.addActionListener(arg0 -> {
            System.out.println("Saving data...");
            System.exit(0);
        });

        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(menuLabel);
        menu.add(newGameButton);
        menu.add(highScoreButton);
        menu.add(exitButton);
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createHorizontalGlue());
        getContentPane().add(menu);
        add(Box.createHorizontalGlue());
    }
}
