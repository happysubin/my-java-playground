package happysubin.javapractice.project.lotto.src.factory;

import happysubin.javapractice.project.lotto.src.model.Prize;

public class PrizeFactory {
    public static Prize createPrize(int count, Boolean bonus) {

        if(count == 6) return Prize.FIRST;
        else if(count == 5 && bonus == true) return Prize.SECOND;
        else if(count == 5) return Prize.THIRD;
        else if(count == 4) return Prize.FOURTH;
        else if(count == 3) return Prize.FIFTH;
        else return Prize.FAIL;
    }
}
