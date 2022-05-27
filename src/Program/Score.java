package Program;

import java.io.Serial;
import java.io.Serializable;

public class Score implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String nickname;
    private int highscore = 0;
    private String time;

    public Score(String nickname, int highscore, String time) {
        this.nickname = nickname;
        this.highscore = highscore;
        this.time = time;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public String string() {
        return time + " " + nickname + " " + highscore;
    }
}
