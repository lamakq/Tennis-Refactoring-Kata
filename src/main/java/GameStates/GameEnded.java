package GameStates;

public class GameEnded extends GameState {

    GameEnded(int player1Score, int player2Score) {
        super(player1Score, player2Score);
    }

    @Override
    public String getStateString() {
        return (player1Score > player2Score) ? "Win for player1" : "Win for player2";
    }
}
