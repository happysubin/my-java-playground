package happysubin.javapractice.javastudy.week4.listnode;

public class NodeIsNullException extends  RuntimeException{

    private static final String MESSAGE = "입력한 리스트 노드의 값이 NULL 입니다.";

    public NodeIsNullException() {
        super(MESSAGE);
    }
}
