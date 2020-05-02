package GameStates;

public class GameAdvantage extends GameState {
    @Override
    public String getStateString(int player1Score, int player2Score) {
        return (player1Score > player2Score) ? "Advantage player1" : "Advantage player2";
    }
}
