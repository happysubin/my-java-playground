package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(List<Player> players) {
        this.players.addAll(players);
    }

    public void allPlayerHasTwoCard(Deck deck){
        OutputView.printReceiveTwoCardNotifications(players.stream().map(Player::getName).collect(toList()));
        players.forEach(player -> player.receiveFirstTwoCards(deck));

    }

    public List<Player> getPlayers() {
        return players;
    }
}
