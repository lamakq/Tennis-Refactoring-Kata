package GameStates;

public abstract class GameState {
    int player1Score;
    int player2Score;

    GameState(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public abstract String getStateString();
}
