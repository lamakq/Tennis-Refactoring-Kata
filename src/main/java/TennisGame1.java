import java.util.HashMap;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isEqualValues(player1Score, player2Score)) {
            return calculateScoreWhenPlayerScoreIsEqual();
        }
        else if (isWinningOrAdvantageCase()) {
            return checkForWinningOrAdvantageCase();
        } else {
            return calculateScoreForEachPlayerTurn();
        }
    }

    private boolean isWinningOrAdvantageCase() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isEqualValues(int player1Score, int player2Score) {
        return player1Score == player2Score;
    }

    private String calculateScoreForEachPlayerTurn() {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (isEqualValues(i, 1)) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            score = appendScoreWhenPlayerScoreIsNotEqual(score, tempScore);
        }
        return score;
    }

    private String appendScoreWhenPlayerScoreIsNotEqual(String score, int tempScore) {
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
        return score;
    }

    private String checkForWinningOrAdvantageCase() {
        String score;
        int minusResult = player1Score - player2Score;
        if (isEqualValues(minusResult, 1)) score = "Advantage player1";
        else if (isEqualValues(minusResult, -1)) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String calculateScoreWhenPlayerScoreIsEqual() {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
