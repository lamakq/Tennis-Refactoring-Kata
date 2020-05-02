import java.util.HashMap;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String score;

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
        resetScore();
        if (isEqualValues(player1Score, player2Score)) {
            return calculateScoreWhenPlayerScoreIsEqual();
        }
        else if (isWinningOrAdvantageCase()) {
            return checkForWinningOrAdvantageCase();
        } else {
            return calculateScoreForEachPlayerTurn();
        }
    }

    private void resetScore() {
        score = "";
    }

    private boolean isWinningOrAdvantageCase() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isEqualValues(int player1Score, int player2Score) {
        return player1Score == player2Score;
    }

    private String calculateScoreForEachPlayerTurn() {
        int playerNumber = 0;
        int playerScore = 0;


        for (int i = 1; i < 3; i++) {
            playerNumber = getPlayerTurn(i);
            playerScore =  getPlayerScore(playerNumber);
            appendScoreWhenPlayerScoreIsNotEqual(playerScore, playerNumber);
        }
        return score;
    }

    private int getPlayerScore(int playerNumber) {
        return (playerNumber == 1) ? player1Score : player2Score;
    }

    private int getPlayerTurn(int i) {
        return i;
    }

    private void appendScoreWhenPlayerScoreIsNotEqual(int playerScore, int playerNumber) {
        if (playerNumber == 2) {
            score += "-";
        }
        switch (playerScore) {
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

    private String checkForWinningOrAdvantageCase() {
        int minusResult = player1Score - player2Score;
        if (isEqualValues(minusResult, 1)) score = "Advantage player1";
        else if (isEqualValues(minusResult, -1)) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String calculateScoreWhenPlayerScoreIsEqual() {
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
}
