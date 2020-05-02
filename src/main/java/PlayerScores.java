public class PlayerScores {

  private int player1Score = 0;
  private int player2Score = 0;

  public int getPlayer1Score() {
    return player1Score;
  }

  public void setPlayer1Score(int score) {
    player1Score = score;
  }

  public int getPlayer2Score() {
    return player2Score;
  }

  public void setPlayer2Score(int score) {
    player2Score = score;
  }

  public boolean areEqual() {
    return player1Score == player2Score;
  }

  public String getDisplayTextForPlayer1() {
    switch(player1Score)
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

  public String getDisplayTextForPlayer2() {
    switch(player2Score)
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
}
