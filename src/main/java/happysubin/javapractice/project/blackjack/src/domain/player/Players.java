package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Players {

    private List<Player> players = new ArrayList<>();
    private Dealer dealer;

    public Players(List<Player> players,Dealer dealer) {
        this.players.addAll(players);
        this.dealer = dealer ;
    }

    public void allPlayerHasTwoCard(Deck deck){
        OutputView.printReceiveTwoCardNotifications(players.stream().map(Player::getName).collect(toList()));
        OutputView.printReceiveTwoCardNotifications(List.of(dealer.getName()));
        players.forEach(player -> player.receiveFirstTwoCards(deck));
        dealer.receiveFirstTwoCards(deck);
        System.out.println();
    }

    public void allPlayerSelectivelyReceiveCard(Deck deck) {
        players.forEach(player -> player.selectivelyReceiveCard(deck));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void printCardList() {
        System.out.println();
        players.forEach(Player::printCardListAndTotalScore);
        dealer.printCardListAndTotalScore();
    }
}
