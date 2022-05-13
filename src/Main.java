import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Player> playerArrayList = new ArrayList<>();
    public static int width = 500;
    public static int height = 500;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Menu(width, height);
        });
    }
}
