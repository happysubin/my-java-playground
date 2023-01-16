package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(List<Player> players) {
        this.players.addAll(players);
    }

    public void allPlayerHasTwoCard(Deck deck){
        players.forEach(player -> player.receiveFirstTwoCards(deck));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
