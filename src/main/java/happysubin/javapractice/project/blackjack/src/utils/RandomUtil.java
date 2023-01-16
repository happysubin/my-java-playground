package happysubin.javapractice.project.blackjack.src.utils;

import java.util.Random;

public class RandomUtil {

    private static class RandomSingleton{
        private static final Random random = new Random();
    }

    private static Random getRandomSingleton(){
        return RandomSingleton.random;
    }

    public static Integer getRandomNumber(Integer number){
        return getRandomSingleton().nextInt(number);
    }
}
