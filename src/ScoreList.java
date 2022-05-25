import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.AbstractList;
import java.util.ArrayList;

public class ScoreList extends AbstractListModel {
    ArrayList<Score> scores;

    public ScoreList() {
        try {
            FileInputStream fis = new FileInputStream("data/highscores.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            scores = (ArrayList<Score>) ois.readObject();

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
