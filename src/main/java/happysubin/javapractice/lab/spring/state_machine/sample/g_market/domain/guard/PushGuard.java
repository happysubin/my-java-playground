package happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.guard;

import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.Events;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.States;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.service.VendingMachineService;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;


/**
 *   이벤트가 발생하면 상태 간의 전이가 발생하게 됩니다. 만약 특정 조건이 만족될 때만 상태 전이를 허용하고 싶다면 Guard를 사용하면 된다.
 */

public class PushGuard implements Guard<States, Events> {

    @Override
    public boolean evaluate(StateContext<States, Events> stateContext) {
        int currentCents = VendingMachineService.getInsertedCents();
        if(currentCents < 30) {
            System.out.println("Not enough money!");
            VendingMachineService.setBeverage(null);
            return false; // 투입 금액이 30센트보다 적으면, guard 통과 불가
        }

        return true; //가드 통과
    }
}
