package GameStates;

public class GameStateFactory {
    
    public static GameState getGameState(int player1Score, int player2Score) {
        if (isGameEnded(player1Score, player2Score)) {
            return new GameEnded(player1Score, player2Score);
        } else if (isGameAdvantage(player1Score, player2Score)) {
            return new GameAdvantage(player1Score, player2Score);
        } else {
            return new GameDefault(player1Score, player2Score);
        }
    }

    private static boolean isAnyPlayerScoreGreaterOrEqualFour(int player1Score, int player2Score) {
        return player1Score >= 4 || player2Score >= 4;
    }

    private static boolean isGameEnded(int player1Score, int player2Score) {
        int scoreDifference = Math.abs(player1Score - player2Score);
        return isAnyPlayerScoreGreaterOrEqualFour(player1Score, player2Score) && (scoreDifference >= 2);
    }

    private static boolean isGameAdvantage(int player1Score, int player2Score) {
        int scoreDifference = Math.abs(player1Score - player2Score);
        return isAnyPlayerScoreGreaterOrEqualFour(player1Score, player2Score) && (scoreDifference == 1);
    }
}
