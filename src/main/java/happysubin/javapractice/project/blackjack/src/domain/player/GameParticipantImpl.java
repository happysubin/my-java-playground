package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import happysubin.javapractice.project.blackjack.src.view.InputView;

import java.util.List;

public class GameParticipantImpl extends AbstractPlayer implements GameParticipant{


    public GameParticipantImpl(PlayerInfo playerInfo) {
        super(playerInfo);
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
    public void firstDrawTwoCard(Deck deck, State state) {
        for (int i = 0; i < 2; i++) {
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        observer.printCardList();
        this.state = StateFactory.extractState(calculateCardsPoint(cardList));
    }

    @Override
    public void lastSelectiveDraw(Deck deck) {
        while(isRunningState()){
            selectiveDraw(deck);
        }
    }

    private void selectiveDraw(Deck deck) {
        observer.printParticipantReceiveCommand();
        if(InputView.inputDrawCommand().equals("y")){
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
            observer.printCardList();
            this.state =  StateFactory.extractState(calculateCardsPoint(cardList));
            return;
        }
        this.state = StateFactory.getFinishState();
    }


    private boolean isRunningState() {
        return state == State.RUNNING;
    }
}
