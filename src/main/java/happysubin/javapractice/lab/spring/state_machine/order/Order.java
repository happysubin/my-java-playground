package happysubin.javapractice.lab.spring.state_machine.order;

import happysubin.javapractice.lab.spring.state_machine.order.OrderState;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String product;

    @Enumerated(EnumType.STRING)
    private OrderState status; // 상태를 저장할 필드


    protected Order() {
    }

    public Order(String customerName, String product, OrderState status) {
        this.customerName = customerName;
        this.product = product;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public OrderState getStatus() {
        return status;
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }
}