package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import happysubin.javapractice.project.blackjack.src.view.InputView;

public class GameParticipant extends AbstractPlayer{

    private PlayerInfo playerInfo;
    private State state;

    public GameParticipant(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.state = State.RUNNING;
    }

    @Override
    public String getName() {
        return playerInfo.getName();
    }

    @Override
    protected void selectiveDraw(Deck deck) {
        observer.printParticipantReceiveCommand();
        if(InputView.inputDrawCommand().equals("y")){
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
            observer.printCardList();
            this.state =  State.RUNNING;
            return;
        }
        this.state = State.FINISH;
    }

    @Override
    public boolean isRunningState() {
        return state == State.RUNNING;
    }
}
