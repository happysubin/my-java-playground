package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter02;

import java.util.Scanner;

public class AppV2 {

    public static void main(String[] args) {

        System.out.println("입력할 주문의 개수를 입력하세요: ");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        sc.nextLine()

        ProductOrder[] orders = new ProductOrder[num];

        for (int i = 0; i < orders.length; i++) {
            System.out.println(i + 1 + "번째 주문 정보를 입력하세요.");

            System.out.println("상품명: ");
            String productName = sc.nextLine();

            System.out.println("가격: ");
            int price = sc.nextInt();

            System.out.println("수량: ");
            int quantity = sc.nextInt();

            orders[i] = new ProductOrder(productName, price, quantity);

        }


        printOrders(orders);
        System.out.println(getTotalAmount(orders));

    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println(order);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int result = 0;
        for (ProductOrder productOrder : orders) {
            result += productOrder.price * productOrder.getQuantity();
        }
        return result;
    }
}
