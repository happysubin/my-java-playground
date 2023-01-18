package happysubin.javapractice.project.blackjack.src;

import happysubin.javapractice.project.blackjack.src.controller.BlackJackGame;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.PlayerFactory;

public class App {
    public static void main(String[] args) {
        BlackJackGame blackJackGame = new BlackJackGame(PlayerFactory.createPlayer(), new Deck());
        blackJackGame.start();
    }
}
