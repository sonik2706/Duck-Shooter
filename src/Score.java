public class Score {
    private String nickname;
    private int highscore = 0;

    public Score(String nickname) {
        this.nickname = nickname;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
}
