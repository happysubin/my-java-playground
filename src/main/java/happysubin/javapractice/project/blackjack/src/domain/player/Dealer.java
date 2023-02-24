package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.BlackJack;
import happysubin.javapractice.project.blackjack.src.domain.player.state.Bust;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

public class Dealer extends AbstractPlayer implements DealerBehavior {

    public Dealer(Cards cards) {
        super(new PlayerInfo("딜러", 0), cards);
    }

    @Override
    public void lastDraw(Deck deck) {
        if(state.getClass() == BlackJack.class) return;

        if(lessPointThan16()){
            observer.printDealerReceiveCommandUnder16();
            this.state = state.draw(drawCardFromDeck(deck));
        }

        state = concludeDealerFinalState();
    }

    private State concludeDealerFinalState() {
        if(state.cards().isBust()){
            return new Bust(state.cards());
        }
        return state.stay();
    }

    private boolean lessPointThan16() {
        return state.cards().lessPointThan16();
    }

    public PlayerInfo compare(State gameParticipantState, PlayerInfo gameParticipantInfo) {
        double finalBetMoney = gameParticipantState.compare(state, gameParticipantInfo.getBetMoney());
        this.playerInfo = playerInfo.calculate(finalBetMoney);
        return new PlayerInfo(gameParticipantInfo.getName(), (int) finalBetMoney);
    }
}
