import java.util.Objects;

public class Player {

    private String name;
    private int score;

    Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void incrementScore() {
        this.score = this.score + 1;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
