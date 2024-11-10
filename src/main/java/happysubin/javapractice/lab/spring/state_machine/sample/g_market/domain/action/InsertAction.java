package happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.action;

import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.Events;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.States;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.service.VendingMachineService;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;


/**
 * 상태가 전이된 후, 일괄적으로 특정 동작을 수행하고 싶을 수도 있습니다. 이런 경우 Action을 이용합니다.
 */

public class InsertAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> stateContext) {
        int currentCents = VendingMachineService.getInsertedCents();

        switch(stateContext.getEvent()) {
            case InsertNickel:
                VendingMachineService.setInsertedCents(currentCents + 5); // Nickel 투입. 5센트 추가
                break;
            case InsertDime:
                VendingMachineService.setInsertedCents(currentCents + 10); // Dime 투입. 10센트 추가
                break;
            case InsertQuarter:
                VendingMachineService.setInsertedCents(currentCents + 25); // Quarter 투입. 25센트 추가
                break;
        }
    }
}
