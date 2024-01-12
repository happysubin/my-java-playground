package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter06;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;
    private int itemCount;


    public ShoppingCart() {
        this.items = new ArrayList<>(10);
        this.itemCount = 10;
    }

    public void addItem(Item item) {
        if(items.size() >= itemCount) {
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }
        items.add(item);
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        int sum = 0;
        for (Item item : items) {
            sum += item.getTotalPrice();
            System.out.println("상품명: " + item.getName() + ", 합계: " + item.getTotalPrice());
        }
        System.out.println("전체 가격 합: " + sum);
    }
}
