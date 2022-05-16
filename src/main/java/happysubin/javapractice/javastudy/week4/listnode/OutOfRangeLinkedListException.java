package happysubin.javapractice.javastudy.week4.listnode;

public class OutOfRangeLinkedListException extends  RuntimeException{


    private static final String MESSAGE = "링크드 리스트에서 이동할 수 있는 범위를 넘어갔습니다";

    public OutOfRangeLinkedListException() {
        super(MESSAGE);
    }
}
