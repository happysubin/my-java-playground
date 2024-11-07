package happysubin.javapractice.lab.multi_tx.main.event.domain;

import happysubin.javapractice.lab.multi_tx.main.event.Event;

public class PreparedFoodEvent extends Event {

    private final Long foodId;

    public PreparedFoodEvent(Long foodId) {
        this.foodId = foodId;
    }

    public Long getFoodId() {
        return foodId;
    }
}
