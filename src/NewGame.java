import javax.swing.*;
import javax.swing.event.DocumentListener;

public class NewGame extends JFrame {

    public NewGame() {
        setSize(500, 500);
        setTitle("Duck Shooter");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        gamePanel.startGameThread();
    }
}
