
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).incrementScore();
    }

    private Player getPlayer(String playerName) {
        if (isPlayerNameMatched(player1, playerName)) {
            return player1;
        } else if (isPlayerNameMatched(player2, playerName)) {
            return player2;
        }
        return null;
    }

    private boolean isPlayerNameMatched(Player player, String playerName) {
        return player.getName().equals(playerName);
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        // scores are equal
        if (isScoreTied()) {
            return getScoreStringWhenTied(this.player1.getScore());
        } else if (isGameAdvantage()) {
            return getScoreStringWhenAdvantage();
        } else if (isGameEnded()) {
            return getScoreStringWhenEnded();
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = this.player1.getScore();
                else {
                    score += "-";
                    tempScore = this.player2.getScore();
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    private String getScoreStringWhenAdvantage() {
        return (player1.getScore() > player2.getScore()) ? "Advantage player1" : "Advantage player2";
    }

    private String getScoreStringWhenEnded() {
        return (player1.getScore() > player2.getScore()) ? "Win for player1" : "Win for player2";
    }

    private boolean isAnyPlayerScoreGreaterOrEqualFour() {
        return this.player1.getScore() >= 4 || this.player2.getScore() >= 4;
    }

    private boolean isGameEnded() {
        int scoreDifference = Math.abs(this.player1.getScore() - this.player2.getScore());
        return isAnyPlayerScoreGreaterOrEqualFour() && (scoreDifference >= 2);
    }

    private boolean isGameAdvantage() {
        int scoreDifference = Math.abs(this.player1.getScore() - this.player2.getScore());
        return isAnyPlayerScoreGreaterOrEqualFour() && (scoreDifference == 1);
    }

    private boolean isScoreTied() {
        return this.player1.getScore() == this.player2.getScore();
    }

    private String getScoreStringWhenTied(int score) {

        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }

    }
}
