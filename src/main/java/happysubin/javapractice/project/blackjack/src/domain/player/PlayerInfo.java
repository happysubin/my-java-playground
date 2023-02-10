package happysubin.javapractice.project.blackjack.src.domain.player;


import java.util.List;

public class PlayerInfo {
    private final String name;
    private int bettingMoney;

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

    public void lossMoney(Integer money) {
        this.bettingMoney -= money;
    }

    public void addMoney(int lossMoney) {
        this.bettingMoney += lossMoney;
    }

    public PlayerInfo blackJackScore() {
        return new PlayerInfo(name, (int) (bettingMoney * 1.5));
    }

    public PlayerInfo win() {
        return new PlayerInfo(name, bettingMoney);
    }

    public PlayerInfo lossAllMoney() {
        return new PlayerInfo(name, bettingMoney * -1);
    }
}
