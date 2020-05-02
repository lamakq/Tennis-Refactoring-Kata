
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;

    public TennisGame1(String player1Name) {
        this.player1Name = player1Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        else
            player2Score += 1;
    }

    private boolean isGameTied() {
        return player1Score == player2Score;
    }

    private String getScoreWhenGameIsTied() {
        switch (player1Score)
        {
            case 0:  return "Love-All";
            case 1:  return "Fifteen-All";
            case 2:  return "Thirty-All";
            default: return "Deuce";
        }
    }

    private boolean isWinningOrAdvantageStatus() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String getScoreWhenGameIsAtWinningOrAdvantageStatus() {
        int scoreDelta = player1Score - player2Score;

        if (scoreDelta==1) {
            return "Advantage player1";
        }
        else if (scoreDelta ==-1) {
            return "Advantage player2";
        }
        else if (scoreDelta>=2) {
            return "Win for player1";
        }

        else {
            return "Win for player2";
        }
    }

    public String getScore() {
        String score = "";
        int tempScore=0;

        if (isGameTied()) {
            score = getScoreWhenGameIsTied();
        }

        else if (isWinningOrAdvantageStatus()) {
            score = getScoreWhenGameIsAtWinningOrAdvantageStatus();
        }

        else {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score;
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
}
