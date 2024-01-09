package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter01;

public class ProductOrder {
    private final String productName;
    private final int price;
    private final int quantity;

    public ProductOrder(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];
        orders[0] = new ProductOrder("두부", 2000, 2);
        orders[1] = new ProductOrder("김치", 5000, 1);
        orders[2] = new ProductOrder("콜라", 1500, 2);

        int totalAmount = 0;
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
            totalAmount += order.price * order.quantity;
        }
        System.out.println("최종 금액: " + totalAmount);
    }
}
