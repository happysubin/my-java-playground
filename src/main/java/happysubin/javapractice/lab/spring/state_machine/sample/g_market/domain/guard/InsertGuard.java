package happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.guard;

import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.Events;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.States;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.service.VendingMachineService;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;

public class InsertGuard implements Guard<States, Events> {

    @Override
    public boolean evaluate(StateContext<States, Events> stateContext) {
        int currentCents = VendingMachineService.getInsertedCents();
        return switch (stateContext.getEvent()) {
            case InsertNickel -> currentCents + 5 <= 30;
            case InsertDime -> currentCents + 10 <= 30;
            case InsertQuarter -> currentCents + 25 <= 30;
            default -> false;
        };
    }
}
