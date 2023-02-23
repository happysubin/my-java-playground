package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

public class Dealer extends AbstractPlayer implements DealerBehavior {

    public Dealer(Cards cards) {
        super(new PlayerInfo("딜러", 0), cards);
    }

    @Override
    public void lastDraw(Deck deck) {
        if(lessPointThan16()){
            observer.printDealerReceiveCommandUnder16();
            this.state = state.draw(drawCardFromDeck(deck));
            return;
        }
        this.state = state.stay();
    }

    private boolean lessPointThan16() {
        return state.cards().lessPointThan16();
    }

    public PlayerInfo compare(Cards gameParticipantCards, PlayerInfo gameParticipantInfo) {
        return null;
//        if(allBlackJack(gameParticipantCards) || allSamePoint(gameParticipantCards)){
//            //0배 취급 안함. 그냥 배팅 금액 돌려줌.
//            return new PlayerInfo(gameParticipantInfo.getName(), 0);
//        }
//        else if(gameParticipantCards.isBlackJack()){
//            //1.5배를 게임 참여자에게 주고 딜러는 그만큼을 잃음.
//            PlayerInfo gameParticipantResult = gameParticipantInfo.blackJackScore();
//            lossMoney(gameParticipantResult.getBettingMoney());
//            return gameParticipantResult;
//        }
//        else if(this.cards.isGameOver() & gameParticipantCards.isNotGameOver()){
//            //살아있는 참가자들은 그냥 배팅 금액만큼 돌려 받음.
//            PlayerInfo gameParticipantResult = gameParticipantInfo.win();
//            lossMoney(gameParticipantResult.getBettingMoney());
//            return gameParticipantResult;
//        }
//        else if(gameParticipantCards.isGameOver() || morePointThanGameParticipants(gameParticipantCards)){
//            //참가자가 게임 오버거나 딜러가 점수가 크면 참가자 돈 다 가져간다.
//            PlayerInfo gameParticipantResult = gameParticipantInfo.lossAllMoney();
//            addMoney(gameParticipantResult.getBettingMoney());
//            return gameParticipantResult;
//        }
//        //참가자가 점수가 더 크면, 참가자가 돈을 가져간다.
//        PlayerInfo gameParticipantResult = gameParticipantInfo.win();
//        lossMoney(gameParticipantResult.getBettingMoney());
//        return gameParticipantResult;
    }

//    private boolean morePointThanGameParticipants(Cards gameParticipantCards) {
//        return this.cards.morePointThan(gameParticipantCards);
//    }
//
//    private boolean allBlackJack(Cards gameParticipantCards) {
//        return gameParticipantCards.isBlackJack() & this.cards.isBlackJack();
//    }
//
//    private boolean allSamePoint(Cards gameParticipantCards) {
//        return gameParticipantCards.isSamePoint(cards);
//    }
//
//    private void lossMoney(Integer bettingMoney) {
//        this.playerInfo.lossMoney(bettingMoney);
//    }
//
//    private void addMoney(Integer bettingMoney) {
//        this.playerInfo.addMoney(bettingMoney * -1);
//    }
}
