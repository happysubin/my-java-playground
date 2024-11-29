package happysubin.javapractice.lab.spring.state_machine.order;

import happysubin.javapractice.lab.spring.state_machine.order.dto.CreateOrderRequest;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/state-machine")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public void createNewOrder(CreateOrderRequest request) {
        orderService.createNewOrder(request.getCustomerName(), request.getProduct());
    }

    @GetMapping("/orders/{orderId}")
    public void placeOrder(@PathVariable Long orderId) {
        orderService.placeOrder(orderId);
    }

    @GetMapping("/orders/{orderId}/complete")
    public void completeOrder(@PathVariable Long orderId) {
        orderService.completeOrder(orderId);
    }

    @GetMapping("/orders/{orderId}/cancel")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }
}
