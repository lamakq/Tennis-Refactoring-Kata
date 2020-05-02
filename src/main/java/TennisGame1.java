
public class TennisGame1 implements TennisGame {

    Score score = new Score();

    public void wonPoint(String playerName) {
        if (player1(playerName))
            score.setPlayer1Score(score.getPlayer1Score() + 1);
        else
            score.setPlayer2Score(score.getPlayer2Score() + 1);
    }

    public String getScore() {
        if (score.scoresAreEqual())
        {
            return getDisplayTextForEqualScore();
        }
        else if (eitherPlayerScoreIsGreaterThanEqualTo4())
        {
            return getDisplayTextForWinOrAdvantage();
        }
        return getDisplayTextForPlayerScore(score.getPlayer1Score()) + "-" + getDisplayTextForPlayerScore(score.getPlayer2Score());
    }

    private boolean player1(String playerName) {
        return playerName == "player1";
    }

    private String getDisplayTextForPlayerScore(int tempScore) {
        switch(tempScore)
        {
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

    private String getDisplayTextForWinOrAdvantage() {

        if (advantageForPlayer1()) return "Advantage player1";
        else if (advantageForPlayer2()) return "Advantage player2";
        else if (player1Won()) return "Win for player1";
        return "Win for player2";

    }

    private boolean player1Won() {
        return (score.getPlayer1Score() - score.getPlayer2Score())>=2;
    }

    private boolean advantageForPlayer1() {
        return (score.getPlayer1Score() - score.getPlayer2Score()) == 1;

    }
    private boolean advantageForPlayer2() {
        return (score.getPlayer2Score() - score.getPlayer1Score()) == 1;

    }

    private boolean eitherPlayerScoreIsGreaterThanEqualTo4() {
        return score.getPlayer1Score() >=4 || score.getPlayer2Score() >=4;
    }

    private String getDisplayTextForEqualScore() {
        switch (score.getPlayer1Score())
        {
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
