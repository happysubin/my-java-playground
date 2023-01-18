package happysubin.javapractice.project.blackjack.src.domain.player.observer;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.view.OutputView;

public class PlayerObserver {

    private Player player;

    public PlayerObserver(Player player) {
        this.player = player;
    }

    public void printCardList() {
        System.out.print(player.getName() + ": ");
        System.out.println(player.getCardList());
    }

    public void printCardListAndTotalScore(){
        System.out.print(player.getName() + ": ");
        System.out.print(player.getCardList());
        System.out.println(
                " - 결과: " +
                player.getCardList().stream().map(Card::getLevelScore).reduce(0, (a, b) -> a + b)
        );
    }

    public void printParticipantReceiveCommand() {
        OutputView.notifyGameParticipantReceiveCommand(player.getName());
    }

    public void printDealerReceiveCommandUnder16() {
        OutputView.notifyDealerReceiveCommandUnder16(player.getName());
    }

    public void printDealerReceiveCommandOver17() {
        OutputView.notifyDealerReceiveCommandOver17(player.getName());
    }
}
