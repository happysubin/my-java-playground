package happysubin.javapractice.project.bridge.src.utils;


import java.util.Random;

public class RandomUtils {

    private static final int RANDOM_NUMBER_RANGE = 2;

    private RandomUtils(){}

    private static class RandomSingleton{
        private final static Random random = new Random();
    }

    private static Random getInstance(){
        return RandomSingleton.random;
    }

    public static int getRandomNumber(){
        return getInstance().nextInt(RANDOM_NUMBER_RANGE);
    }
}
