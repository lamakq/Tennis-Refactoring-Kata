package domain;

public class Player {

    private String name;
    private int score;
    private Score playerScore;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.playerScore = new Score();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void wonPoint() {
        score++;
    }

    public String handleScoreEqualCase() {
        return this.playerScore.handleScoreEqualCase(this);
    }

    public String getScoreDisplayName() {
        return this.playerScore.getScoreDisplayName(this);
    }
}
