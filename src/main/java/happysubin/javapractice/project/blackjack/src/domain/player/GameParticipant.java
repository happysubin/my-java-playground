package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;

import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import static happysubin.javapractice.project.blackjack.src.view.InputView.*;

public class GameParticipant extends AbstractPlayer implements GameParticipantBehavior {

    public GameParticipant(PlayerInfo playerInfo) {
        super(playerInfo);
    }

    @Override
    public void lastSelectiveDraw(Deck deck) {
        while(isRunningState()){
            observer.printParticipantReceiveCommand();
            selectiveDraw(deck);
            observer.printCardList();
        }
    }

    private void selectiveDraw(Deck deck) {
        if(inputCommandIsY()){
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
            this.state = StateFactory.lastGameParticipantExtractState(calculateCardsPoint());
            return;
        }
        this.state = StateFactory.finishState();
    }

    private boolean inputCommandIsY() {
        return inputDrawCommand().equals("y");
    }

    private boolean isRunningState() {
        return state == State.RUNNING;
    }

    public void compareWithDealer(Dealer dealer) {
        if(state == State.BLACK_JACK){
        }
        else if(state == State.GAME_OVER){
            dealer.addBettingMoney(playerInfo.lossMoney());
        }
    }
}

/**
 * 첫 번째는 블랙잭이 되지만
 * 두 번재부터는 21이 되도 블랙잭이 아님.
 *
 */
