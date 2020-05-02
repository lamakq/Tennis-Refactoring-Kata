package domain;

public class Player {

    private String name;
    private Score playerScore;

    public Player(String name) {
        this.name = name;
        this.playerScore = new Score();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return playerScore.getScore();
    }

    public void wonPoint() {
        playerScore.addScore();
    }

    public String handleScoreEqualCase() {
        return this.playerScore.handleScoreEqualCase();
    }

    public String getScoreDisplayName() {
        return this.playerScore.getScoreDisplayName();
    }

    public boolean areScoresEqual(Player player) {
        return getScore() == player.getScore();
    }
}
