package app.controller;

import app.model.*;
import app.view.Receiver;
import app.view.Viewer;

import java.util.List;
import java.util.stream.Collectors;

public class Blackjack {
    private final Dealer dealer;
    private final DeckOfCards deckOfCards;
    private Players players;

    public Blackjack(Dealer dealer, DeckOfCards deckOfCards) {
        this.dealer = dealer;
        this.deckOfCards = deckOfCards;
    }

    public void play() {
        setPlayers();
        initGame();
        rotatePlayers();
        showCards();
        showWins();
    }

    private void setPlayers() {
        try {
            List<Gambler> gamblerList = createGamblerList();
            players = new Players(gamblerList, dealer);
        } catch(IllegalArgumentException error) {
            System.err.println(error.getMessage());
            setPlayers();
        }
    }

    private List<Gambler> createGamblerList() {
        return Receiver.askPlayerNames().stream()
                .map(playerNameStr -> new PlayerName(playerNameStr))
                .map(playerName -> new Gambler(playerName, new Cards(deckOfCards)))
                .collect(Collectors.toList());
    }

    private void initGame() {
        deckOfCards.shuffleDeck();
        players.receiveStartingCards();

        List<String> gamblerNameList = players.getGamblerList().stream()
                .map(gambler -> gambler.getPlayerNameStr())
                .collect(Collectors.toList());
        int numCards = players.getGamblerList().get(0).startingCardStrList().size();

        Viewer.startingAnnouncement(dealer.getPlayerNameStr(), gamblerNameList, numCards);
        Viewer.showCards(PlayerDto.startingOf(dealer));
        players.getGamblerList().stream().forEach(gambler -> Viewer.showCards(PlayerDto.startingOf(gambler)));
    }

    private void rotatePlayers() {
        players.getGamblerList().stream().forEach(gambler -> rotateGambler(gambler));
        rotateDealer();
    }

    private void rotateGambler(Gambler gambler) {
        while (gambler.canDraw() && Receiver.askDraw(gambler.getPlayerNameStr())) {
            gambler.drawCard(1);
            Viewer.showCards(PlayerDto.of(gambler));
        }
    }

    private void rotateDealer() {
        if (dealer.canDraw()) {
            dealer.drawCard(1);
            Viewer.dealerDraw(PlayerDto.of(dealer), dealer.getDrawUnder());
        }
    }

    private void showCards() {
        Viewer.showSumCards(PlayerDto.sumOf(dealer));
        players.getGamblerList().stream().forEach(gambler -> Viewer.showSumCards(PlayerDto.sumOf(gambler)));
    }

    private void showWins() {
        players.checkWins();
        Viewer.winsAnnouncement();
        Viewer.showWins(PlayerWinDto.from(dealer));
        players.getGamblerList().stream().forEach(gambler -> Viewer.showWins(PlayerWinDto.from(gambler)));
    }
}
