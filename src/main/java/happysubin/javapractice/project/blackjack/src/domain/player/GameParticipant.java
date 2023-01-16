package happysubin.javapractice.project.blackjack.src.domain.player;

public class GameParticipant extends AbstractPlayer{

    private PlayerInfo playerInfo;

    public GameParticipant(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }
}
