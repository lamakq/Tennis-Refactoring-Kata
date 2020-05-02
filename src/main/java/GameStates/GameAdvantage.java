package GameStates;

public class GameAdvantage extends GameState {

    GameAdvantage(int player1Score, int player2Score) {
        super(player1Score, player2Score);
    }

    @Override
    public String getStateString() {
        return (player1Score > player2Score) ? "Advantage player1" : "Advantage player2";
    }
}
