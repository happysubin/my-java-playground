package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

public class GameParticipant implements Player{

    private PlayerInfo playerInfo;
    private List<Card> cardList = new ArrayList<>();

    public GameParticipant(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }
}
