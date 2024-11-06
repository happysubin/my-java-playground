package happysubin.javapractice.lab.jpa.one_to_one;


import happysubin.javapractice.lab.multi_tx.main.one_to_one.ChildOne;
import happysubin.javapractice.lab.multi_tx.main.one_to_one.ChildOneRepository;
import happysubin.javapractice.lab.multi_tx.main.one_to_one.One;
import happysubin.javapractice.lab.multi_tx.main.one_to_one.OneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class OneToOneTest {


    @Autowired
    private OneRepository oneRepository;

    @Autowired
    private ChildOneRepository childOneRepository;


    @Test
    void 연관관계주인_단순조회() {

        //조회문이 1개 나옴.

        ChildOne child1 = new ChildOne("child1");

        One one = new One("name");

        one.setChildOne(child1);

        One saveOne = oneRepository.save(one);

        System.out.println("=======");

        One result = oneRepository.findById(saveOne.getId()).orElseThrow();

        System.out.println("result = " + result);
    }

    @Test
    void 연관관계자식_단순조회() {

        //조회문이 2개 나온다고 예측

        ChildOne child1 = new ChildOne("child1");

        One one = new One("name");

        one.setChildOne(child1);

        One saveOne = oneRepository.save(one);

        ChildOne childOne = childOneRepository.findAll().get(0);

        System.out.println("childOne = " + childOne);
    }
}
