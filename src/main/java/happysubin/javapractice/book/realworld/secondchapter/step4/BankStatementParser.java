package happysubin.javapractice.book.realworld.SecondChapter.step4;


import java.util.List;

public interface BankStatementParser {

    BankTransaction parseFrom(String Line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}

/**
 * CSV파일이 아닌 JSON 파일을 파싱한다고 생각하자.
 * 그러면 psvm 메서드가 있는 메인 클래스에서 JSON 파일을  파싱하는 클래스를 의존할 것이다.
 * 그러면 구체클래스를 의존하면서 코드를 수정할 부분이 많아지고 DIP 원칙에도 걸린다.
 * 의존관계에서 유연한 결합을 위해 다형성을 적극 활용한다. 파서라는 interface를 만들고
 * 파서 인터페이스의 메소드를 각 CSV 파서, XML 파서, JSON 파서가 오버라이딩한다.
 * 그러면 우리는 인터페이스에 의존하게 되면서 이전보다 코드를 수정할 일이 적어지고, 유연한 의존관계를 가지게 된다.
 * 즉 결합도가 낮아진다는 것이다.
 * 응집성은 높을수록 좋지만, 결합성은 낮을수록 좋다.
 */