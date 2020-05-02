import static utills.AppConstant.ADVANTAGE;
import static utills.AppConstant.ALL;
import static utills.AppConstant.DEUCE;
import static utills.AppConstant.FIFTEEN;
import static utills.AppConstant.FORTY;
import static utills.AppConstant.LOVE;
import static utills.AppConstant.THIRTY;
import static utills.AppConstant.WIN;

public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
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

    private boolean areScoresEqual(){
        return player1Score == player2Score;
    }

    private boolean isAdvantageOrWinningCase() {
        return player1Score >=4 || player2Score >=4;
    }

    private String handleNormalCase(String score) {
        int tempScore=0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = player1Score;
            else { score+="-"; tempScore = player2Score;}
            switch(tempScore)
            {
                case 0:
                    score+=LOVE;
                    break;
                case 1:
                    score+=FIFTEEN;
                    break;
                case 2:
                    score+=THIRTY;
                    break;
                case 3:
                    score+=FORTY;
                    break;
            }
        }
        return score;
    }

    private String handleAdvantageOrWinningCase() {
        return getScoreTypeByDifference();
    }

    private String getScoreTypeByDifference() {
        if (isAdvantagePlayer1()) {
            return ADVANTAGE + player1Name;
        }
        if (isAdvantagePlayer2()) {
            return ADVANTAGE + player2Name;
        }
        if (isWiningPlayer1()) {
            return WIN + player1Name;
        }
        return WIN + player2Name;
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
