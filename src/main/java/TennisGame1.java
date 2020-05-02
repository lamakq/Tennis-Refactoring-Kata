public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name,String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        else
            player2Score += 1;
    }

    private boolean isGameTied() {
        return player1Score == player2Score;
    }

    private String getScoreWhenGameIsTied() {
        switch (player1Score) {
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

    private boolean isWinningOrAdvantageStatus() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String getScoreFromInteger(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String getScoreWhenGameIsAtWinningOrAdvantageStatus() {
        int scoreDelta = player1Score - player2Score;

        if (scoreDelta == 1) {
            return "Advantage "+player1Name;
        } else if (scoreDelta == -1) {
            return "Advantage "+player2Name;
        } else if (scoreDelta >= 2) {
            return "Win for "+player1Name;
        } else {
            return "Win for "+player2Name;
        }
    }

    public String getScore() {
        if (isGameTied()) {
            return getScoreWhenGameIsTied();
        } else if (isWinningOrAdvantageStatus()) {
            return getScoreWhenGameIsAtWinningOrAdvantageStatus();
        } else {
            return String.format("%s-%s", getScoreFromInteger(player1Score), getScoreFromInteger(player2Score));
        }
    }
}
