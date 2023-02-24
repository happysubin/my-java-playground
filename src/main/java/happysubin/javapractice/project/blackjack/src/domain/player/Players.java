package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

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

    public void firstDrawTwoCards(Deck deck){
        OutputView.printReceiveTwoCardNotifications(extractAllName());
        dealer.firstDrawTwoCard(deck);
        gameParticipantsFirstDrawTwoCard(deck);
    }

    private List<String> extractAllName(){
        List<String> result = gameParticipants.stream().map(Player::getName).collect(toList());
        result.add(dealer.getName());
        return result;
    }

    private void gameParticipantsFirstDrawTwoCard(Deck deck) {
        for (GameParticipant gameParticipant : gameParticipants) {
            gameParticipant.firstDrawTwoCard(deck);
        }
    }

    public void lastDrawCards(Deck deck) {
        for (GameParticipant gameParticipant : gameParticipants) {
            gameParticipant.lastSelectiveDraw(deck);
        }
        dealer.lastDraw(deck);
    }

    public void printCardList() {
        gameParticipants.forEach(Player::printCardListAndTotalScore);
        dealer.printCardListAndTotalScore();
    }

    public void compareDealerAndGameParticipants(){
        for (GameParticipant gameParticipant : gameParticipants) {
            gameParticipant.compareWithDealer(dealer);
        };
    }

    public void printResult() {
        List<PlayerInfo> playerInfos = extractAllPlayerInfo();
        playerInfos.forEach(OutputView::printResult);
    }

    private List<PlayerInfo> extractAllPlayerInfo() {
        List<PlayerInfo> result = gameParticipants.stream().map(Player::getPlayerInfo).collect(toList());
        result.add(dealer.getPlayerInfo());
        return result;
    }

    /**
     * 아래는 테스트를 위한 코드
     */

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(dealer);
        players.addAll(gameParticipants);
        return players;
    }

    public List<GameParticipant> getGameParticipants() {
        return gameParticipants;
    }

    public Dealer getDealer() {
        return dealer;
    }
}
