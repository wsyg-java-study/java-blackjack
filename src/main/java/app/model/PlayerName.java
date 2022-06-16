package app.model;

import java.util.Objects;

public class PlayerName {
    private final String playerNameStr;

    public PlayerName(String playerNameStr) {
        validate(playerNameStr);
        this.playerNameStr = playerNameStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(playerNameStr, that.playerNameStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNameStr);
    }

    public String getPlayerNameStr() {
        return playerNameStr;
    }

    private void validate(String playerNameStr) {
        if (playerNameStr.length() < 1 || playerNameStr.length() > 10) {
            throw new PlayerNameException("이름은 1자 이상 10자 이하입니다.");
        }
    }

    static class PlayerNameException extends IllegalArgumentException {
        public PlayerNameException(String message) {
            super(message);
        }
    }
}
