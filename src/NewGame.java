import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class NewGame extends JFrame {

    public NewGame(int width, int height) {

        setSize(width, height);
        setTitle("Duck Shooter");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Timer timer = new Timer();
        timer.start();

        JLabel time = new JLabel(timer.getTime());
//        time.setText(timer.getTime());

        add(time);

//        timer.interrupt();
    }
}
