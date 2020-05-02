
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
        if (player1(playerName))
            player1Score += 1;
        else
            player2Score += 1;
    }

    private boolean player1(String playerName) {
        return playerName == "player1";
    }

    public String getScore() {



        if (scoreIsEqual(player1Score, player2Score))
        {
            return getDisplayTextForEqualScore();


        }
        else if (eitherPlayerScoreIsGreaterThanEqualTo4())
        {
            return getDisplayTextForWinOrAdvantage();

        }
        String score = "";
        score = getDisplayTextForPlayerScore(player1Score);
        score += "-";
        score += getDisplayTextForPlayerScore(player2Score);
        return score;


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
        String score;
        int minusResult = player1Score - player2Score;
        if (scoreIsEqual(minusResult, 1)) score ="Advantage player1";
        else if (scoreIsEqual(minusResult, -1)) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean eitherPlayerScoreIsGreaterThanEqualTo4() {
        return player1Score >=4 || player2Score >=4;
    }

    private String getDisplayTextForEqualScore() {
        String score;
        switch (player1Score)
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
