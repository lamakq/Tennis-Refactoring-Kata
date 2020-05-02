import domain.Player;

import static utills.AppConstant.ADVANTAGE;
import static utills.AppConstant.ALL;
import static utills.AppConstant.DEUCE;
import static utills.AppConstant.FIFTEEN;
import static utills.AppConstant.FORTY;
import static utills.AppConstant.LOVE;
import static utills.AppConstant.THIRTY;
import static utills.AppConstant.WIN;

public class TennisGame1 implements TennisGame {

    private static int DEFAULT_SCORE = 0;
    private int player1Score = 0;
    private int player2Score = 0;

    //private String player1.getName();
    //private String player2.getName();

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {

        player1 = new Player(player1Name, DEFAULT_SCORE);
        player2 = new Player(player2Name, DEFAULT_SCORE);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (areScoresEqual()) {
            score = handleScoreEqualCase();
        } else if (isAdvantageOrWinningCase()) {
            score = handleAdvantageOrWinningCase();
        } else {
            score = handleNormalCase(score);
        }
        return score;
    }

    private boolean areScoresEqual() {
        return player1Score == player2Score;
    }

    private boolean isAdvantageOrWinningCase() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String handleNormalCase(String score) {

        score += getScoreDisplayName(player1Score);
        score = score + "-";
        score += getScoreDisplayName(player2Score);
        return score;
    }

    private String getScoreDisplayName(int tempScore) {
        switch (tempScore) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
            default:
                return "";
        }
    }

    private String handleAdvantageOrWinningCase() {
        if (isAdvantagePlayer1()) {
            return ADVANTAGE + player1.getName();
        }
        if (isAdvantagePlayer2()) {
            return ADVANTAGE + player2.getName();
        }
        if (isWiningPlayer1()) {
            return WIN + player1.getName();
        }
        return WIN + player2.getName();
    }

    private boolean isWiningPlayer1() {
        return getPlayerScoreDifference() >= 2;
    }

    private boolean isAdvantagePlayer2() {
        return getPlayerScoreDifference() == -1;
    }

    private boolean isAdvantagePlayer1() {
        return getPlayerScoreDifference() == 1;
    }

    private int getPlayerScoreDifference() {
        return player1Score - player2Score;
    }

    private String handleScoreEqualCase() {
        switch (player1Score) {
            case 0:
                return LOVE + "-" + ALL;
            case 1:
                return FIFTEEN + "-" + ALL;
            case 2:
                return THIRTY + "-" + ALL;
            default:
                return DEUCE;
        }
    }
}
