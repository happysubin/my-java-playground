package happysubin.javapractice.project.blackjack.src.domain.player.observer;

import happysubin.javapractice.project.blackjack.src.domain.player.Player;

public class PlayerObserver {

    private Player player;

    public PlayerObserver(Player player) {
        this.player = player;
    }

    public void printCardList() {
        System.out.print(player.getName() + ": ");
        System.out.println(player.getCardList());
    }
}
