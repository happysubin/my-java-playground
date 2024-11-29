package happysubin.javapractice.lab.spring.state_machine.order;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderService {

    private final StateMachineService stateMachineService;
    private final OrderRepository orderRepository;

    public OrderService(StateMachineService stateMachineService, OrderRepository orderRepository) {
        this.stateMachineService = stateMachineService;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void createNewOrder(String customerName, String product) {
        Order order = new Order(customerName, product, OrderState.NEW);
        Order savedOrder = orderRepository.save(order);
        stateMachineService.acquireStateMachine(String.valueOf(savedOrder.getId())); //저장됨
    }

    @Transactional
    public void placeOrder(Long orderId) {
        StateMachine stateMachine = stateMachineService.acquireStateMachine(String.valueOf(orderId));
        stateMachine.sendEvent(OrderEvent.PLACE_ORDER);
    }

    @Transactional
    public void completeOrder(Long orderId) {
        StateMachine stateMachine = stateMachineService.acquireStateMachine(String.valueOf(orderId));
        stateMachine.sendEvent(OrderEvent.COMPLETE_ORDER);
    }


    @Transactional
    public void cancelOrder(Long orderId) {
        StateMachine stateMachine = stateMachineService.acquireStateMachine(String.valueOf(orderId));
        stateMachine.sendEvent(OrderEvent.CANCEL_ORDER);
    }
}

