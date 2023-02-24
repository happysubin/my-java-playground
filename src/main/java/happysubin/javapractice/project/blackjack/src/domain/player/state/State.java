package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

public interface State {
    State draw(Card card);
    State stay();
    boolean isFinished();
    Cards cards();
    double profit(double profit);
    double compare(State dealerState, int betMoney);
}