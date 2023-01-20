package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Players {

    private List<GameParticipant> gameParticipants = new ArrayList<>();
    private Dealer dealer;

    public Players(List<GameParticipant> gameParticipants, Dealer dealer) {
        this.gameParticipants.addAll(gameParticipants);
        this.dealer = dealer ;
    }

    public void allPlayerHasTwoCard(Deck deck){
        OutputView.printReceiveTwoCardNotifications(extractAllName());
        State dealerState = dealer.firstDrawTwoCard(deck);
        List<Double> gameParticipantGetMoney = gameParticipantDrawTwoCardAndGetGameParticipantGainedMoney(deck, dealerState);
        dealer.lossBettingMoney(gameParticipantGetMoney);
    }

    private List<Double> gameParticipantDrawTwoCardAndGetGameParticipantGainedMoney(Deck deck, State dealerState) {
        return gameParticipants.stream()
                .map(gameParticipant -> gameParticipant.firstDrawTwoCard(deck, dealerState))
                .collect(toList());
    }

    public void hasLastChanceGetCard(Deck deck) {
        gameParticipants.forEach(gameParticipant -> gameParticipant.lastSelectiveDraw(deck));
        dealer.lastDraw(deck);
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(dealer);
        players.addAll(gameParticipants);
        return players;
    }

    public void printCardList() {
        System.out.println();
        gameParticipants.forEach(Player::printCardListAndTotalScore);
        dealer.printCardListAndTotalScore();
    }

    private List<String> extractAllName(){
        List<String> result = gameParticipants.stream().map(Player::getName).collect(toList());
        result.add(dealer.getName());
        return result;
    }
}
