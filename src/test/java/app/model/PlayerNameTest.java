package app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNameTest {
    private DeckOfCards deckOfCards;

    @BeforeEach
    void setDeckAndDealer() {
        deckOfCards = new DeckOfCards();
    }

    @Test
    @DisplayName("이름이 영건인 Player를 만들 수 있다.")
    void createGambler() {
        PlayerName playerName = new PlayerName("영건");
        assertThat(playerName.getPlayerNameStr()).isEqualTo("영건");
    }

    @Test
    @DisplayName("이름은 1자 이상 10자 이하이어야 한다.")
    void validateGamblerName() {
        String shortName = "";
        String longName = "thisnameistoolong";
        assertThatThrownBy(() -> new PlayerName(shortName)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PlayerName(longName)).isInstanceOf(IllegalArgumentException.class);
    }
}
