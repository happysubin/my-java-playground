package happysubin.javapractice.lab.spring.state_machine.sample.g_market.service;


import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.Events;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.States;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

//@Service
public class VendingMachineService {

    private static final Logger log = LoggerFactory.getLogger(VendingMachineService.class);

    private final StateMachine<States, Events> stateMachine;


    public VendingMachineService(StateMachine<States, Events> stateMachine) {
        this.stateMachine = stateMachine;
    }

    private static int insertedCents = 0;

    private static String beverage;

    @PostConstruct
    private void init() {
        stateMachine.start();
        log.info("vending machine created");
    }

    public ResponseModel insertNickel() {
        stateMachine.sendEvent(Events.InsertNickel);
        return new ResponseModel(insertedCents, null, stateMachine.getState().getId().toString());
    }

    public ResponseModel insertDime() {
        stateMachine.sendEvent(Events.InsertDime);
        return new ResponseModel(insertedCents, null, stateMachine.getState().getId().toString());
    }

    public ResponseModel insertQuarter() {
        stateMachine.sendEvent(Events.InsertQuarter);
        return new ResponseModel(insertedCents, null, stateMachine.getState().getId().toString());
    }

    public ResponseModel pushOrangeJuice() {
        stateMachine.sendEvent(Events.PushOrangeJuice);
        return new ResponseModel(insertedCents, beverage, stateMachine.getState().getId().toString());
    }

    public ResponseModel pushAppleJuice() {
        stateMachine.sendEvent(Events.PushAppleJuice);
        return new ResponseModel(insertedCents, beverage, stateMachine.getState().getId().toString());
    }

    public static int getInsertedCents() {
        return insertedCents;
    }

    public static String getBeverage() {
        return beverage;
    }

    public static void setInsertedCents(int insertedCents) {
        VendingMachineService.insertedCents = insertedCents;
    }

    public static void setBeverage(String beverage) {
        VendingMachineService.beverage = beverage;
    }
}