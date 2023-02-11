package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

import static happysubin.javapractice.project.blackjack.src.utils.RandomUtil.*;
import static happysubin.javapractice.project.blackjack.src.view.InputView.*;

public class GameParticipant extends AbstractPlayer implements GameParticipantBehavior {

    public GameParticipant(PlayerInfo playerInfo) {
        super(playerInfo);
    }

    @Override
    public void lastSelectiveDraw(Deck deck) {
        while(cards.isRunning()){
            observer.printParticipantReceiveCommand();
            selectiveDraw(deck);
            observer.printCardList();
        }
    }

    private void selectiveDraw(Deck deck) {
        if(inputCommandIsY()){
            cards.addCard(deck.drawCard(getRandomNumber(deck.getDeckSize())));
            cards.lastGameParticipantExtractState();
            return;
        }
        cards.finish();
    }

    private boolean inputCommandIsY() {
        return inputDrawCommand().equals("y");
    }

    public void compareWithDealer(Dealer dealer) {
        this.playerInfo =  dealer.compare(cards, playerInfo);
    }
}

/**
 * 첫 번째는 블랙잭이 되지만
 * 두 번재부터는 21이 되도 블랙잭이 아님.
 *
 */
