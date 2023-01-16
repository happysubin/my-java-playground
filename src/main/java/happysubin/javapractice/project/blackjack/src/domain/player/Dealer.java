package happysubin.javapractice.project.blackjack.src.domain.player;

public class Dealer extends AbstractPlayer{
    private final String name;

    public Dealer() {
        this.name = "딜러";
    }

    @Override
    public String getName() {
        return name;
    }
}
