package happysubin.javapractice.lab.spring.state_machine.order.action;

import happysubin.javapractice.lab.spring.state_machine.order.OrderRepository;
import happysubin.javapractice.lab.spring.state_machine.order.dto.CreateOrderRequest;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;


@Component
public class CreateNewOrderAction implements Action {

    private final OrderRepository orderRepository;

    public CreateNewOrderAction(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute(StateContext stateContext) {
        stateContext.getExtendedState().get("createOrderRequest", CreateOrderRequest.class);
    }
}
