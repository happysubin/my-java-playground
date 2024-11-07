package happysubin.javapractice.lab.multi_tx.main.event.service;

import happysubin.javapractice.lab.multi_tx.main.event.domain.Food;
import happysubin.javapractice.lab.multi_tx.main.event.domain.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodService {


    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Transactional
    public void makeFood() {
        Food food = new Food("bibim");
        foodRepository.save(food);
        food.prepared();
    }
}
