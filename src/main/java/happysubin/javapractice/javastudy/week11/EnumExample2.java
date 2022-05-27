package happysubin.javapractice.javastudy.week11;

import java.util.EnumSet;

enum Transportation{
    BUS(100){
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },

    TRAIN(150){
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    SHIP(100){
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    AIRPLANE(300){
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    protected  final int BASIC_FARE; //protected로 해야 각 상수에서 접근가능하다.

    Transportation(int basicFare) {
        this.BASIC_FARE = basicFare;
    }

    public int getBASIC_FARE() {
        return BASIC_FARE;
    }

    abstract int fare(int distance); //거리에 따라 계산할 추상 메서드
}

public class EnumExample2 {
    public static void main(String[] args) {
        System.out.println("Transportation.BUS.fare(100) = " + Transportation.BUS.fare(100));
        System.out.println("Transportation.TRAIN.fare(100) = " + Transportation.TRAIN.fare(100));
        System.out.println("Transportation.SHIP.fare(100) = " + Transportation.SHIP.fare(100));
        System.out.println("Transportation.AIRPLANE.fare(100) = " + Transportation.AIRPLANE.fare(100));
    }
}


