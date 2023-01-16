package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.draw.DealerStrategy;
import happysubin.javapractice.project.blackjack.src.domain.draw.DrawStrategy;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;

import java.util.List;

public class Dealer extends AbstractPlayer{
    private final String name;
    private final DrawStrategy drawStrategy;

    public Dealer() {
        this.name = "딜러";
        this.drawStrategy = new DealerStrategy();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected boolean selectiveDraw(Deck deck, List<Card> cardList, PlayerObserver observer) {
        return drawStrategy.draw(deck, cardList, observer);
    }
}
