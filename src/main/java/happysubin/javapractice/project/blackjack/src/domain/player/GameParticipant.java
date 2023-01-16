package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.draw.DrawStrategy;
import happysubin.javapractice.project.blackjack.src.domain.draw.GameParticipantDrawStrategy;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;

import java.util.List;

public class GameParticipant extends AbstractPlayer{

    private PlayerInfo playerInfo;
    private final DrawStrategy drawStrategy;

    public GameParticipant(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.drawStrategy = new GameParticipantDrawStrategy();
    }

    @Override
    public String getName() {
        return playerInfo.getName();
    }

    @Override
    protected boolean selectiveDraw(Deck deck, List<Card> cardList, PlayerObserver observer) {
        return drawStrategy.draw(deck, cardList, observer);
    }
}
