package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;

import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

public class Dealer extends AbstractPlayer implements DealerBehavior {

    public Dealer() {
        super(new PlayerInfo("딜러", 0));
    }

    @Override
    public void lastDraw(Deck deck) {
        if(calculateCardsPoint() <= 16){
            observer.printDealerReceiveCommandUnder16();
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        this.state = StateFactory.lastDealerExtractState(calculateCardsPoint());
    }

    public void compare(int calculateCardsPoint, PlayerInfo playerInfo) {
        if(calculateCardsPoint < calculateCardsPoint()){
            this.playerInfo.addMoney(playerInfo.lossMoney());
        }
    }

    public void addBettingMoney(int lossMoney) {
        playerInfo.addMoney(lossMoney);
    }

    public boolean isGamerOver(){
        return state == State.GAME_OVER;
    }

    public boolean isBlackJack() {
        return state == State.BLACK_JACK;
    }
}
