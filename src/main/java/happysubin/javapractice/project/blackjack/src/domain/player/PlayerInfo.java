package happysubin.javapractice.project.blackjack.src.domain.player;

public class PlayerInfo {

    private final String name;
    private final int betMoney;

    public PlayerInfo(String name, int betMoney) {
        this.name = name;
        this.betMoney = betMoney;
    }

    public String getName() {
        return name;
    }

    public Integer getBetMoney() {
        return betMoney;
    }

    public PlayerInfo calculate(double money){
        return new PlayerInfo(name, (int) (this.betMoney - money));
    }
}
