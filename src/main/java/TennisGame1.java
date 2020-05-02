public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    private TennisPlayer player1;
    private TennisPlayer player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private boolean isGameTied() {
        return player1Score == player2Score;
    }

    private boolean isLateGame() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isGameAtAdvantage() {
        int scoreDelta = player1Score - player2Score;
        return isLateGame() && Math.abs(scoreDelta) == 1;
    }

    private boolean isGameWon() {
        int scoreDelta = player1Score - player2Score;
        return isLateGame() && Math.abs(scoreDelta) >= 2;
    }


    private String getScoreWhenGameIsAtAdvantage() {
        return "Advantage " + getPlayerAtAdvantage();
    }

    private String getScoreWhenGameIsWon() {
        return "Win for " + getPlayerAtAdvantage();
    }

    private String getPlayerAtAdvantage() {
        return player1Score > player2Score ? player1Name : player2Name;
    }

    public String getScore() {
        if (isGameTied()) {
            return ScoreHelper.getScoreWhenGameIsTied(player1Score);
        } else if (isGameAtAdvantage()) {
            return getScoreWhenGameIsAtAdvantage();
        } else if (isGameWon()) {
            return getScoreWhenGameIsWon();
        } else {
            return getFormattedScore();
        }
    }

    private String getFormattedScore() {
        return String.format("%s-%s", ScoreHelper.getScoreFromInteger(player1Score),
            ScoreHelper.getScoreFromInteger(player2Score));
    }
}
