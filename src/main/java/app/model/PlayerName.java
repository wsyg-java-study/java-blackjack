package app.model;

import java.util.Objects;

public class PlayerName {
    private final String playerName;

    public PlayerName(String playerNameStr) {
        this.playerName = playerNameStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}