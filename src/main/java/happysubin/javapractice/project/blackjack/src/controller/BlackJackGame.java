package happysubin.javapractice.project.blackjack.src.controller;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.domain.player.Players;

import java.util.List;

public class BlackJackGame {

    private Deck deck;
    private Players players;

    public BlackJackGame(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = new Players(players);
    }

    public void start(){
        players.allPlayerHasTwoCard(deck);
    }
}
