package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

public class Dealer extends AbstractPlayer{

    private final String name;
    private State state;

    public Dealer() {
        this.name = "딜러";
        this.state = State.RUNNING;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected void selectiveDraw(Deck deck) {
        if(calculateCardsPoint(cardList) <= 16){
            observer.printDealerReceiveCommandUnder16();
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        this.state = StateFactory.getFinishState();
    }

    @Override
    public boolean isRunningState() {
        return state == State.RUNNING;
    }
}
