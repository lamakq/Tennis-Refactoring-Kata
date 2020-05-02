import GameStates.GameState;
import GameStates.GameStateFactory;

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).incrementScore();
    }

    private Player getPlayer(String playerName) {
        if (isPlayerNameMatched(player1, playerName)) {
            return player1;
        } else if (isPlayerNameMatched(player2, playerName)) {
            return player2;
        }
        return null;
    }

    private boolean isPlayerNameMatched(Player player, String playerName) {
        return player.getName().equals(playerName);
    }

    public String getScore() {
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();

        GameState gameState = GameStateFactory.getGameState(player1Score, player2Score);
        return gameState.getStateString();
    }
}
