package happysubin.javapractice.project.blackjack.src.controller;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.Dealer;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.domain.player.Players;

import java.util.List;

public class BlackJackGame {

    private Players players;
    private Deck deck;

    public BlackJackGame(List<GameParticipant> players, Deck deck) {
        this.players = new Players(players, new Dealer());
        this.deck = deck;
    }

    public void start(){
        players.allPlayerHasTwoCard(deck);
        players.hasLastChanceGetCard(deck);
        players.printCardList();
        //TODO 결과 출력 끝.
    }


    public Players getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }
}
