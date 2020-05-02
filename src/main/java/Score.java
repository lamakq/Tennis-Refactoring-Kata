public class Score {

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

  public boolean scoresAreEqual() {
    return player1Score == player2Score;
  }
}
