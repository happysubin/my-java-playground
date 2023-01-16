package happysubin.javapractice.project.blackjack.src.controller;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.PlayerFactory;
import happysubin.javapractice.project.blackjack.src.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

    private Deck deck;
    private List<Player> players = new ArrayList<>();

    public BlackJackGame(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players.addAll(players);
    }

    public void start(){
    }
}
