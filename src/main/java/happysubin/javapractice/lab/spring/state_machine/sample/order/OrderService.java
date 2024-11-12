package happysubin.javapractice.lab.spring.state_machine.sample.order;

import happysubin.javapractice.lab.multi_tx.main.Order;
import happysubin.javapractice.lab.multi_tx.main.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private StateMachine<OrderState, OrderEvent> stateMachine;

    @Autowired
    private StateMachinePersister<OrderState, OrderEvent, Long> stateMachinePersister;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void placeOrder(Long orderId) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        stateMachine.getExtendedState().getVariables().put("orderId", orderId);

        stateMachine.sendEvent(OrderEvent.PLACE_ORDER);
        stateMachinePersister.persist(stateMachine, order.getId()); // 상태 저장
    }

    @Transactional
    public void processOrder(Long orderId) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        stateMachine.getExtendedState().getVariables().put("orderId", orderId);

        stateMachine.sendEvent(OrderEvent.PROCESS_ORDER);
        stateMachinePersister.persist(stateMachine, order.getId()); // 상태 저장
    }

    @Transactional
    public void completeOrder(Long orderId) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        stateMachine.getExtendedState().getVariables().put("orderId", orderId);

        stateMachine.sendEvent(OrderEvent.COMPLETE_ORDER);
        stateMachinePersister.persist(stateMachine, order.getId()); // 상태 저장
    }

    @Transactional
    public void cancelOrder(Long orderId) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        stateMachine.getExtendedState().getVariables().put("orderId", orderId);

        stateMachine.sendEvent(OrderEvent.CANCEL_ORDER);
        stateMachinePersister.persist(stateMachine, order.getId()); // 상태 저장
    }
}

