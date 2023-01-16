package happysubin.javapractice.project.blackjack.src.domain.draw;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;

import java.util.List;

@FunctionalInterface
public interface DrawStrategy {
    boolean draw(Deck deck, List<Card> cardList, PlayerObserver observer);
}
