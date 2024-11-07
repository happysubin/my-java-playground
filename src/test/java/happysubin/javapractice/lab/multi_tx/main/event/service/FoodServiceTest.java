package happysubin.javapractice.lab.multi_tx.main.event.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodServiceTest {

    @Autowired
    FoodService foodService;

    @Test
    void 이벤트_핸들러_롤백_테스트() {
        foodService.makeFood();
    }
}