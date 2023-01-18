package happysubin.javapractice.project.blackjack.src.domain.player.factory;

import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipantImpl;
import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.view.InputView;

import java.util.List;

import static java.util.stream.Collectors.*;

public class PlayerFactory {

    public static List<GameParticipant> createPlayer(){
        List<GameParticipant> result = InputView
                .inputPlayerName()
                .stream()
                .map(InputView::inputPlayerBettingMoney)
                .map(GameParticipantImpl::new)
                .collect(toList());
        return result;
    }
}
