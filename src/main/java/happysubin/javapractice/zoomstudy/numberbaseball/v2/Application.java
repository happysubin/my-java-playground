package happysubin.javapractice.zoomstudy.numberbaseball.v2;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame(new Player(), new Computer());
        game.start();
    }
}
