
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
        String score = "";
        int tempScore=0;
        // scores are equal
        if (scoreIsEqual(player1Score, player2Score))
        {
            score = getDisplayTextForEqualScore();
        }
        // winning and advantage cases
        else if (player1Score >=4 || player2Score >=4)
        {
            int minusResult = player1Score - player2Score;
            if (scoreIsEqual(minusResult, 1)) score ="Advantage player1";
            else if (scoreIsEqual(minusResult, -1)) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (scoreIsEqual(i, 1)) tempScore = player1Score;
                else { score+="-"; tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
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
