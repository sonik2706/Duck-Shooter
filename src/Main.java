import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Score> scoreArrayList = new ArrayList<>();
    public static int width = 500;
    public static int height = 500;

    public static void addScore(Score sc) {
        scoreArrayList.add(sc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Menu(width, height);
        });
    }
}
