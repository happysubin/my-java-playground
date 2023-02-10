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

    public PlayerInfo compare(int gameParticipantPoint, State gameParticipantState, PlayerInfo gameParticipantInfo) {
        if(allBlackJack(gameParticipantState) || allSamePoint(gameParticipantPoint)){
            //0배 취급 안함. 그냥 배팅 금액 돌려줌.
            return new PlayerInfo(playerInfo.getName(), 0);
        }
        else if(gameParticipantState == State.BLACK_JACK){
            //1.5배를 게임 참여자에게 주고 딜러는 그만큼을 잃음.
            PlayerInfo gameParticipantResult = gameParticipantInfo.blackJackScore();
            lossMoney(gameParticipantResult.getBettingMoney());
            return gameParticipantResult;
        }
        else if(state == State.GAME_OVER & gameParticipantState != State.GAME_OVER){
            //살아있는 참가자들은 그냥 배팅 금액만큼 돌려 받음.
            PlayerInfo gameParticipantResult = gameParticipantInfo.win();
            lossMoney(gameParticipantResult.getBettingMoney());
            return gameParticipantResult;
        }
        else if(gameParticipantState == State.GAME_OVER || gameParticipantPoint < calculateCardsPoint()){
            //참가자가 게임 오버거나 딜러가 점수가 크면 참가자 돈 다 가져간다.
            PlayerInfo gameParticipantResult = gameParticipantInfo.lossAllMoney();
            addMoney(gameParticipantResult.getBettingMoney());
            return gameParticipantResult;
        }
        //참가자가 점수가 더 크면, 참가자가 돈을 가져간다.
        PlayerInfo gameParticipantResult = gameParticipantInfo.win();
        lossMoney(gameParticipantResult.getBettingMoney());
        return gameParticipantResult;
    }

    private boolean allSamePoint(int gameParticipantPoint) {
        return gameParticipantPoint == calculateCardsPoint();
    }

    private boolean allBlackJack(State gameParticipantState) {
        return state == State.BLACK_JACK & gameParticipantState == State.BLACK_JACK;
    }

    private void lossMoney(Integer bettingMoney) {
        this.playerInfo.lossMoney(bettingMoney);
    }

    private void addMoney(Integer bettingMoney) {
        this.playerInfo.addMoney(bettingMoney * -1);
    }


    public boolean isBlackJack() {
        return state == State.BLACK_JACK;
    }
}
