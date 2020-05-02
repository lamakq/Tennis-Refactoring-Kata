import domain.Player;

import static utills.AppConstant.ADVANTAGE;
import static utills.AppConstant.WIN;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.wonPoint();
        } else {
            player2.wonPoint();
        }
    }

    public String getScore() {
        String score = "";
        if (player1.areScoresEqual(player2)) {
            score = player1.handleScoreEqualCase();
        } else if (isAdvantageOrWinningCase()) {
            score = handleAdvantageOrWinningCase();
        } else {
            score = handleNormalCase(score);
        }
        return score;
    }

    private boolean isAdvantageOrWinningCase() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private String handleNormalCase(String score) {
        score += player1.getScoreDisplayName();
        score += "-";
        score += player2.getScoreDisplayName();
        return score;
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
        return player1.getScore() - player2.getScore();
    }
}
