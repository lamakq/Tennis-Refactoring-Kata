package GameStates;

public class GameDefault extends GameState {
    @Override
    public String getStateString(int player1Score, int player2Score) {
        if (areScoresEqual(player1Score, player2Score)){
           return getScoreStringWhenTied(player1Score);
        }
        return getScoreStringWhenScoresDifferentAndLessThanFour(player1Score, player2Score);
    }

    private String getScoreStringWhenScoresDifferentAndLessThanFour(int player1Score, int player2Score) {
        return mapScoreToString(player1Score) + "-" + mapScoreToString(player2Score);
    }

    private boolean areScoresEqual(int player1Score, int player2Score) {

        return  player1Score == player2Score;
    }


    private String mapScoreToString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return  "Forty";
            default:
                return "";
        }
    }

    private String getScoreStringWhenTied(int score) {
        if (score < 3) {
            return mapScoreToString(score) + "-All";
        }
        return "Deuce";
    }

}
