
public class TennisGame1 implements TennisGame {

    PlayerScores playerScores = new PlayerScores();

    public void wonPoint(String playerName) {
        if (player1(playerName))
            playerScores.setPlayer1Score(playerScores.getPlayer1Score() + 1);
        else
            playerScores.setPlayer2Score(playerScores.getPlayer2Score() + 1);
    }

    public String getPlayerScores() {
        if (playerScores.areEqual())
        {
            return getDisplayTextForEqualScore();
        }
        else if (eitherPlayerScoreIsGreaterThanEqualTo4())
        {
            return getDisplayTextForWinOrAdvantage();
        }
        return playerScores.getDisplayTextForPlayer1() + "-" + playerScores.getDisplayTextForPlayer2();
    }

    private boolean player1(String playerName) {
        return playerName == "player1";
    }

    private String getDisplayTextForWinOrAdvantage() {

        if (advantageForPlayer1()) return "Advantage player1";
        else if (advantageForPlayer2()) return "Advantage player2";
        else if (player1Won()) return "Win for player1";
        return "Win for player2";

    }

    private boolean player1Won() {
        return (playerScores.getPlayer1Score() - playerScores.getPlayer2Score())>=2;
    }

    private boolean advantageForPlayer1() {
        return (playerScores.getPlayer1Score() - playerScores.getPlayer2Score()) == 1;

    }
    private boolean advantageForPlayer2() {
        return (playerScores.getPlayer2Score() - playerScores.getPlayer1Score()) == 1;

    }

    private boolean eitherPlayerScoreIsGreaterThanEqualTo4() {
        return playerScores.getPlayer1Score() >=4 || playerScores.getPlayer2Score() >=4;
    }

    private String getDisplayTextForEqualScore() {
        switch (playerScores.getPlayer1Score())
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
