package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

import static happysubin.javapractice.project.blackjack.src.view.InputView.*;

public class GameParticipant extends AbstractPlayer implements GameParticipantBehavior {

    public GameParticipant(PlayerInfo playerInfo, Cards cards) {
        super(playerInfo, cards);
    }

    @Override
    public void lastSelectiveDraw(Deck deck) {
        while(!state.isFinished()){
            observer.printParticipantReceiveCommand();
            selectiveDraw(deck);
            observer.printCardList();
        }
    }

    private void selectiveDraw(Deck deck) {
        if(inputCommandIsY()){
            this.state = state.draw(drawCardFromDeck(deck));
            return;
        }
        this.state = state.stay();
    }

    private boolean inputCommandIsY() {
        return inputDrawCommand().equals("y");
    }

    public void compareWithDealer(Dealer dealer) {
        this.playerInfo =  dealer.compare(state, playerInfo);
    }
}
