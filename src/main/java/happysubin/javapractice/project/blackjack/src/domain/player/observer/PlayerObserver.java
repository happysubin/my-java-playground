package happysubin.javapractice.project.blackjack.src.domain.player.observer;

import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.view.OutputView;

public class PlayerObserver {

    private Player player;

    public PlayerObserver(Player player) {
        this.player = player;
    }

    public void printCardList() {
        System.out.print(player.getName() + ": ");
        System.out.println(player.getCards().getCards() + "\n");
    }

    public void printCardListAndTotalScore(){
        System.out.print(player.getName() + ": ");
        System.out.print(player.getCards().getCards());
        System.out.println(
                " - 결과: " + player.getTotalScore()
        );
    }

    public void printParticipantReceiveCommand() {
        OutputView.notifyGameParticipantReceiveCommand(player.getName());
    }

    public void printDealerReceiveCommandUnder16() {
        OutputView.notifyDealerReceiveCommandUnder16(player.getName());
    }
}
