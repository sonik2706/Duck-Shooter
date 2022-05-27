package Program;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreList extends AbstractListModel {
    ArrayList<Score> scores;

    public ScoreList() {
        try {
            FileInputStream fis = new FileInputStream("data/highscores.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            scores = (ArrayList<Score>) ois.readObject();
            scores.sort((c1, c2) -> (int) (c2.getHighscore() - c1.getHighscore()));

            ois.close();
            fis.close();
        }
        catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        return scores.size();
    }

    @Override
    public Object getElementAt(int index) {
        return scores.get(index).string();
    }
}
