package happysubin.javapractice.project.blackjack.src.controller;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.DealerImpl;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipantImpl;
import happysubin.javapractice.project.blackjack.src.domain.player.Players;

import java.util.List;

public class BlackJackGame {

    private Players players;
    private Deck deck;

    public BlackJackGame(List<GameParticipantImpl> players, Deck deck) {
        this.players = new Players(players, new DealerImpl());
        this.deck = deck;
    }

    public void start(){
        players.allPlayerHasTwoCard(deck);
        players.hasLastChanceGetCard(deck);
        players.printCardList();
        //TODO 결과 출력 끝.
    }
}
