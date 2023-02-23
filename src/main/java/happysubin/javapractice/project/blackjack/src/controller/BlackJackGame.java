package happysubin.javapractice.project.blackjack.src.controller;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.Dealer;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.domain.player.Players;

import java.util.List;

public class BlackJackGame {

    private Players players;
    private Deck deck;

    public BlackJackGame(List<GameParticipant> players, Deck deck) {
        this.players = new Players(players, new Dealer(new Cards()));
        this.deck = deck;
    }

    public void start(){
        players.firstDrawTwoCards(deck);
        players.lastDrawCards(deck);
        players.printCardList();
        players.compareDealerAndGameParticipants();
        players.printResult();
    }
}
