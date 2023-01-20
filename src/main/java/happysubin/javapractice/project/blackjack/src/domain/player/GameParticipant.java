package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import happysubin.javapractice.project.blackjack.src.view.InputView;


public class GameParticipant extends AbstractPlayer implements GameParticipantBehavior {

    public GameParticipant(PlayerInfo playerInfo) {
        super(playerInfo);
    }

    public GameParticipant(Cards cards, PlayerInfo playerInfo) {
        super(cards, playerInfo);
    }

    @Override
    public double firstDrawTwoCard(Deck deck, State dealerState) {
        for (int i = 0; i < 2; i++) {
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        observer.printCardList();
        super.state = StateFactory.extractState(calculateCardsPoint());
        return playerInfo.calculateBlackJack(dealerState, super.state);
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
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
            observer.printCardList();
            this.state = StateFactory.extractState(calculateCardsPoint());
            return;
        }
        this.state = StateFactory.getFinishState();
    }

    private boolean isRunningState() {
        return state == State.RUNNING;
    }
}
