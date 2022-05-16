package happysubin.javapractice.javastudy.week4.listnode;

public class PositionIsMinusException extends  RuntimeException{


    private static final String MESSAGE = "입력하신 포지션의 값이 음수입니다.";

    public PositionIsMinusException() {
        super(MESSAGE);
    }
}
