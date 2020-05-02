public class TennisPlayer {

    String name;
    Integer score;

    public TennisPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }
}
