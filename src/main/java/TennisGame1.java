
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1.getName()))
            this.player1.incrementScore();
        else if (playerName.equals(this.player2.getName()))
            this.player2.incrementScore();
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        // scores are equal
        if (this.player1.getScore() == this.player2.getScore())
        {
            switch (this.player1.getScore())
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
        }
        // winning and advantage cases
        else if (this.player1.getScore() >=4 || this.player2.getScore() >=4)
        {
            int minusResult = this.player1.getScore() - this.player2.getScore();
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = this.player1.getScore();
                else { score+="-"; tempScore = this.player2.getScore();}
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
