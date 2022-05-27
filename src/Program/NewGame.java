package Program;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class NewGame extends JFrame implements KeyListener {

    Game game;
    public NewGame(int level) throws IOException {
        setSize(500, 500);
        setTitle("Duck Shooter");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addKeyListener(this);

        game = new Game();
        game.setLevel(level);
        add(game);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
            game.time.interrupt();
            game.gameThread.interrupt();

            System.out.println("Game stopped.");
            SwingUtilities.invokeLater(() -> {
                this.dispose();
                new Menu(500,500);
            });
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
