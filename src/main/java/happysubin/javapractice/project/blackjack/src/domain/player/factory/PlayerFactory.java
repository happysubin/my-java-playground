package happysubin.javapractice.project.blackjack.src.domain.player.factory;

import happysubin.javapractice.project.blackjack.src.domain.player.Dealer;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.view.InputView;

import java.util.List;

import static java.util.stream.Collectors.*;

public class PlayerFactory {

    public static List<Player> createPlayer(){
        List<Player> result = InputView
                .inputPlayerName()
                .stream()
                .map(InputView::inputPlayerBettingMoney)
                .map(GameParticipant::new)
                .collect(toList());
        result.add(new Dealer());
        return result;
    }
}
