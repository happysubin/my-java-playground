package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter02;

public class AppV1 {

    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];
        orders[0] = createOrder("두부", 2000, 2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 1500, 2);

        printOrders(orders);
        System.out.println(getTotalAmount(orders));

    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        return new ProductOrder(productName, price, quantity);
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
