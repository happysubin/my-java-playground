package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter07;

public class CarMain {

    public static void main(String[] args) {
        Car car1 = new Car("K3");
        Car car2 = new Car("G80");
        Car car3 = new Car("Model Y");
        Car.showTotalCars(); //구매한 차량 수를 출력하는 static 메서드
    }
}