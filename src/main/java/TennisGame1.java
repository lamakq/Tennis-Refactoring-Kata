
public class TennisGame1 implements TennisGame {

    public TennisGame1() {
        Score.player1Score = 0;
        Score.player2Score = 0;
    }

    public void wonPoint(String playerName) {
        if (player1(playerName))
            Score.setPlayer1Score(Score.getPlayer1Score(Score.player1Score) + 1);
        else
            Score.setPlayer2Score(Score.getPlayer2Score() + 1);
    }

    public String getScore() {
        if (scoreIsEqual(Score.getPlayer1Score(Score.player1Score), Score.getPlayer2Score()))
        {
            return getDisplayTextForEqualScore();
        }
        else if (eitherPlayerScoreIsGreaterThanEqualTo4())
        {
            return getDisplayTextForWinOrAdvantage();
        }
        return getDisplayTextForPlayerScore(Score.getPlayer1Score(Score.player1Score)) + "-" + getDisplayTextForPlayerScore(Score.getPlayer2Score());
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
        return (Score.getPlayer1Score(Score.player1Score) - Score.getPlayer2Score())>=2;
    }

    private boolean advantageForPlayer1() {
        return (Score.getPlayer1Score(Score.player1Score) - Score.getPlayer2Score()) == 1;

    }
    private boolean advantageForPlayer2() {
        return (Score.getPlayer2Score() - Score.getPlayer1Score(Score.player1Score)) == 1;

    }

    private boolean eitherPlayerScoreIsGreaterThanEqualTo4() {
        return Score.getPlayer1Score(Score.player1Score) >=4 || Score.getPlayer2Score() >=4;
    }

    private String getDisplayTextForEqualScore() {
        String score;
        switch (Score.getPlayer1Score(Score.player1Score))
        {
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

    private boolean scoreIsEqual(int player1Score, int player2Score) {
        return player1Score == player2Score;
    }

}
