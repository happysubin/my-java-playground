package happysubin.javapractice.project.blackjack.src.domain.draw;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import happysubin.javapractice.project.blackjack.src.view.InputView;

import java.util.List;

public class GameParticipantDrawStrategy implements DrawStrategy{

    @Override
    public boolean draw(Deck deck, List<Card> cardList, PlayerObserver observer) {
        observer.printParticipantReceiveCommand();
        if(InputView.inputDrawCommand().equals("y")){
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
            observer.printCardList();
            return true;
        }
        return false;
    }
}
