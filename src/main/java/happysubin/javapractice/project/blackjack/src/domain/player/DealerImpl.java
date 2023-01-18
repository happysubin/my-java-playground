package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import java.util.List;

public class DealerImpl extends AbstractPlayer implements Dealer{

    public DealerImpl() {
        super(new PlayerInfo("딜러", 0));
    }

    @Override
    public String getName() {
        return playerInfo.getName();
    }

    @Override
    public List<Card> getCardList() {
        return cardList;
    }

    @Override
    public State firstDrawTwoCard(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        observer.printCardList();
        return StateFactory.extractState(calculateCardsPoint(cardList));
    }

    @Override
    public void lastDraw(Deck deck) {
        if(calculateCardsPoint(cardList) <= 16){
            observer.printDealerReceiveCommandUnder16();
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        this.state = StateFactory.getFinishState();
    }
}
