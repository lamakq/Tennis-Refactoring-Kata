public class TennisPlayer {

    String name;
    Integer score;

    public TennisPlayer(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }
}
