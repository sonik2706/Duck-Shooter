public class Player {
    private String nickname;
    private int highscore = 0;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
}
