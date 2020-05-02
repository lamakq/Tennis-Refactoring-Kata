import java.util.Arrays;
import java.util.List;

public class TennisGame1 implements TennisGame {

    private TennisPlayer player1;
    private TennisPlayer player2;

    private List<TennisPlayer> players;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new TennisPlayer(player1Name);
        this.player2 = new TennisPlayer(player2Name);

        this.players = Arrays.asList(this.player1, this.player2);
    }

    public void wonPoint(String playerName) {
        players.stream().filter(player -> player.getName().equals(playerName)).findFirst().get().incrementScore();
    }

    private boolean isGameTied() {
        return player1.getScore() == player2.getScore();
    }

    private boolean isLateGame() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private boolean isGameAtAdvantage() {
        int scoreDelta = player1.getScore() - player2.getScore();
        return isLateGame() && Math.abs(scoreDelta) == 1;
    }

    private boolean isGameWon() {
        int scoreDelta = player1.getScore() - player2.getScore();
        return isLateGame() && Math.abs(scoreDelta) >= 2;
    }


    private String getScoreWhenGameIsAtAdvantage() {
        return "Advantage " + getPlayerAtAdvantage();
    }

    private String getScoreWhenGameIsWon() {
        return "Win for " + getPlayerAtAdvantage();
    }

    private String getPlayerAtAdvantage() {
        return player1.getScore() > player2.getScore() ? player1.getName() : player2.getName();
    }

    public String getScore() {
        if (isGameTied()) {
            return ScoreHelper.getScoreWhenGameIsTied(player1.getScore());
        } else if (isGameAtAdvantage()) {
            return getScoreWhenGameIsAtAdvantage();
        } else if (isGameWon()) {
            return getScoreWhenGameIsWon();
        } else {
            return getFormattedScore();
        }
    }

    private String getFormattedScore() {
        return String.format("%s-%s", ScoreHelper.getScoreFromInteger(player1.getScore()),
            ScoreHelper.getScoreFromInteger(player2.getScore()));
    }
}
