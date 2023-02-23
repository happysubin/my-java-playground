package happysubin.javapractice.project.blackjack.src.domain.player.factory;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.view.InputView;

import java.util.List;

import static java.util.stream.Collectors.*;

public class PlayerFactory {

    public static List<GameParticipant> createPlayer(){
        List<GameParticipant> result = InputView
                .inputPlayerName()
                .stream()
                .map(InputView::inputPlayerBettingMoney)
                .map(playerInfo -> new GameParticipant(playerInfo, new Cards()))
                .collect(toList());
        return result;
    }
}
