package happysubin.javapractice.lab.spring.state_machine.order;

import happysubin.javapractice.lab.spring.state_machine.order.custom.CustomStateMachineService;
import org.hibernate.Transaction;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class OrderService {

    private final CustomStateMachineService stateMachineService;
    private final OrderRepository orderRepository;

    private final StateMachineFactory stateMachineFactory;

    public OrderService(CustomStateMachineService stateMachineService, OrderRepository orderRepository, StateMachineFactory stateMachineFactory) {
        this.stateMachineService = stateMachineService;
        this.orderRepository = orderRepository;
        this.stateMachineFactory = stateMachineFactory;
    }

    @Transactional
    public void createNewOrder(String customerName, String product) {
        Order order = new Order(customerName, product, OrderState.NEW);
        Order savedOrder = orderRepository.save(order);
        System.out.println("TransactionSynchronizationManager.getCurrentTransactionName() = " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        stateMachineService.saveNewStateMachine(String.valueOf(savedOrder.getId())); //저장됨
    }

    @Transactional
    public void placeOrder(Long orderId) {
        StateMachine stateMachine = stateMachineService.acquireStateMachine(String.valueOf(orderId));
        System.out.println("TransactionSynchronizationManager.getCurrentTransactionName() = " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        stateMachine.getExtendedState().getVariables().put("orderId", orderId);
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(OrderEvent.PLACE_ORDER).build())
        ).subscribe();
//        throw new RuntimeException("123123");
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

