package happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.action;

import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.Events;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.States;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.service.VendingMachineService;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class PushAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> stateContext) {
        int currentCents = VendingMachineService.getInsertedCents();
        VendingMachineService.setInsertedCents(currentCents - 30);
        switch (stateContext.getEvent()) {
            case PushAppleJuice:
                VendingMachineService.setBeverage("Apple Juice");
                break;
            case PushOrangeJuice:
                VendingMachineService.setBeverage("Orange Juice");
                break;
        }
    }
}
