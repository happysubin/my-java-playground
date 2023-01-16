package happysubin.javapractice.project.blackjack.src.domain;

public class PlayerInfo {
    private final String name;
    private final Integer bettingMoney;

    public PlayerInfo(String name, Integer bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public String getName() {
        return name;
    }

    public Integer getBettingMoney() {
        return bettingMoney;
    }
}
