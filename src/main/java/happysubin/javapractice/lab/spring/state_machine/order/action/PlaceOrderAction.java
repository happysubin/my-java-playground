package happysubin.javapractice.lab.spring.state_machine.order.action;

import happysubin.javapractice.lab.spring.state_machine.order.Order;
import happysubin.javapractice.lab.spring.state_machine.order.OrderEvent;
import happysubin.javapractice.lab.spring.state_machine.order.OrderRepository;
import happysubin.javapractice.lab.spring.state_machine.order.OrderState;
import happysubin.javapractice.lab.spring.state_machine.order.dto.CreateOrderRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachineException;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Component
public class PlaceOrderAction implements Action<OrderState, OrderEvent> {

    private final OrderRepository orderRepository;

    public PlaceOrderAction(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void execute(StateContext stateContext) {
        Long orderId = stateContext.getExtendedState().get("orderId", Long.class);
        Order order = orderRepository.findById(Long.valueOf(orderId)).get();
        order.setStatus(OrderState.PROCESSING);
        System.out.println("TransactionSynchronizationManager.getCurrentTransactionName() = " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        throw new StateMachineException("asdf");
    }
}
