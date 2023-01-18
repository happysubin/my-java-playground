package happysubin.javapractice.project.blackjack.src.controller;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.Dealer;
import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.domain.player.Players;

import java.util.List;

public class BlackJackGame {

    private Players players;
    private Deck deck;

    public BlackJackGame(List<Player> players, Deck deck) {
        this.players = new Players(players, new Dealer());
        this.deck = deck;
    }

    public void start(){
        players.allPlayerHasTwoCard(deck);
        players.allPlayerSelectivelyReceiveCard(deck);
        players.printCardList();
    }
}
