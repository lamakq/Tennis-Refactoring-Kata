import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        players.stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .get()
                .incrementScore();
    }

    private boolean isGameTied() {
        return players.stream()
                .map(TennisPlayer::getScore)
                .distinct()
                .count() == 1;
    }

    private boolean isLateGame() {
        return players.stream()
                .map(TennisPlayer::getScore)
                .anyMatch(score -> score >= 4);
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
        return players.stream().max(TennisPlayer::compareTo).get().getName();
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
        return players.stream()
                .map(TennisPlayer::getScore)
                .map(ScoreHelper::getScoreFromInteger)
                .collect(Collectors.joining("-"));
    }
}
