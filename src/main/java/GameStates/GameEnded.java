package GameStates;

public class GameEnded extends GameState {

    @Override
    public String getStateString(int player1Score, int player2Score) {
        return (player1Score > player2Score) ? "Win for player1" : "Win for player2";
    }
}
