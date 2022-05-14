package happysubin.javapractice.javastudy.week4.stack;

//int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
//void push(int data)를 구현하세요.
//int pop()을 구현하세요.

public class StackByArray {
    private int max = 5;
    private int top = -1;
    private int [] stack = new int [max];


    private final String EMPTY_STACK = "스택이 비었습니다";
    private final String FULL_STACK = "스택이 비었습니다";

    boolean isEmpty(){
        if(top == -1) return true;
        else return false;
    }

    boolean isFull(){
        if(top == (max - 1)) return true;
        else return false;
    }

    void push(int data){
        if(isFull()){
            throw new FullStackException("스택이 Full 합니다");
        }
        stack[++top] = data; //전위 연산자. 값을 먼저 올리고 넣는다. -1 인덱스에서 넣으면 오류가 발생하기 때문
    }

    int pop(){
        if(isEmpty()){
            throw new EmptyStackException("스택이 empty 합니다");
        }
        int result = stack[top--]; //해당 데이터를 빼고 값을 넣어야 한다. 쉽게 말해 0 인덱스의 값을 빼고 -1로 바꾸어주어야한다.
        return result;
    }


    public int[] getStack() {
        return stack;
    }
}


