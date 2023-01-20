package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;

import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

public class Dealer extends AbstractPlayer implements DealerBehavior {

    public Dealer() {
        super(new PlayerInfo("딜러", 0));
    }

    @Override
    public State firstDrawTwoCard(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        observer.printCardList();
        return StateFactory.extractState(calculateCardsPoint(cards.getCards()));
    }

    @Override
    public void lastDraw(Deck deck) {
        if(calculateCardsPoint(cards.getCards()) <= 16){
            observer.printDealerReceiveCommandUnder16();
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        this.state = StateFactory.getFinishState();
    }
}
