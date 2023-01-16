package happysubin.javapractice.project.blackjack.src.domain.draw;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import java.util.List;

public class DealerStrategy implements DrawStrategy{

    @Override
    public boolean draw(Deck deck, List<Card> cardList, PlayerObserver observer) {
        if(calculateCardsPoint(cardList) <= 16){
            observer.printDealerReceiveCommandUnder16();
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
            observer.printCardList();
            return true;
        }
        observer.printDealerReceiveCommandOver17();
        return false;
    }

    private int calculateCardsPoint(List<Card> cardList) {
        return cardList.stream().map(Card::getLevelScore).reduce(0, (a, b) -> a + b);
    }
}
