package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter08;

public abstract class Item {

    private final String name;
    private final int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("이름: " + name +  " , 가격:" + price);
        printDetail();
    }

    protected abstract void printDetail();


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
