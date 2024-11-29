package happysubin.javapractice.lab.spring.state_machine.order.dto;

public class CreateOrderRequest {

    private final String customerName;
    private final String product;

    public CreateOrderRequest(String customerName, String product) {
        this.customerName = customerName;
        this.product = product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProduct() {
        return product;
    }
}
