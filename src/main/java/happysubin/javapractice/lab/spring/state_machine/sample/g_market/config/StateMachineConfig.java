package happysubin.javapractice.lab.spring.state_machine.sample.g_market.config;


import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.Events;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.States;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.action.InsertAction;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.action.PushAction;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.guard.InsertGuard;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.domain.guard.PushGuard;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.service.VendingMachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<States, Events> {


    private static final Logger log = LoggerFactory.getLogger(StateMachineConfig.class);



    @Bean
    InsertAction insertAction() {
        return new InsertAction();
    }

    @Bean
    InsertGuard insertGuard() {
        return new InsertGuard();
    }

    @Bean
    PushAction pushAction() {
        return new PushAction();
    }

    @Bean
    PushGuard pushGuard() {
        return new PushGuard();
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.S0)
                .state(States.S5)
                .state(States.S10)
                .state(States.S15)
                .state(States.S20)
                .state(States.S25)
                .state(States.S30);
                //.end(States.End) // 최종 상태가 존재하는 경우

    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                // insert nickel
                .withExternal()
                .source(States.S0).target(States.S5).event(Events.InsertNickel)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S5).target(States.S10).event(Events.InsertNickel)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S10).target(States.S15).event(Events.InsertNickel)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S15).target(States.S20).event(Events.InsertNickel)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S20).target(States.S25).event(Events.InsertNickel)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S25).target(States.S30).event(Events.InsertNickel)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withInternal()
                .source(States.S30).event(Events.InsertNickel)
                // insert dime
                .and()
                .withExternal()
                .source(States.S0).target(States.S10).event(Events.InsertDime)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S5).target(States.S15).event(Events.InsertDime)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S10).target(States.S20).event(Events.InsertDime)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S15).target(States.S25).event(Events.InsertDime)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S20).target(States.S30).event(Events.InsertDime)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S25).target(States.S30).event(Events.InsertDime)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withInternal()
                .source(States.S30).event(Events.InsertDime)
                // insert quarter
                .and()
                .withExternal()
                .source(States.S0).target(States.S25).event(Events.InsertQuarter)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S5).target(States.S30).event(Events.InsertQuarter)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S10).target(States.S30).event(Events.InsertQuarter)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S15).target(States.S30).event(Events.InsertQuarter)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S20).target(States.S30).event(Events.InsertQuarter)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withExternal()
                .source(States.S25).target(States.S30).event(Events.InsertQuarter)
                .guard(insertGuard()).action(insertAction())
                .and()
                .withInternal()
                .source(States.S30).event(Events.InsertQuarter)
                .and()
                .withExternal()
                .source(States.S0).target(States.S0).event(Events.PushAppleJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S5).target(States.S5).event(Events.PushAppleJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S10).target(States.S10).event(Events.PushAppleJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S15).target(States.S15).event(Events.PushAppleJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S20).target(States.S20).event(Events.PushAppleJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S25).target(States.S25).event(Events.PushAppleJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S30).target(States.S0).event(Events.PushAppleJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S0).target(States.S0).event(Events.PushOrangeJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S5).target(States.S5).event(Events.PushOrangeJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S10).target(States.S10).event(Events.PushOrangeJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S15).target(States.S15).event(Events.PushOrangeJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S20).target(States.S20).event(Events.PushOrangeJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S25).target(States.S25).event(Events.PushOrangeJuice)
                .guard(pushGuard()).action(pushAction())
                .and()
                .withExternal()
                .source(States.S30).target(States.S0).event(Events.PushOrangeJuice)
                .guard(pushGuard()).action(pushAction());

    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        StateMachineListenerAdapter<States, Events> adapter = new StateMachineListenerAdapter<>(){
            @Override
            public void stateChanged(State<States, Events> fromState, State<States, Events> toState) {
                // 리스너의 동작을 구현
                log.info("State changed from {} to {}. Current cents {}",
                        fromState == null ? "start": fromState.getId().toString(),
                        toState.getId().toString(),
                        VendingMachineService.getInsertedCents());
            }
        };

        config.withConfiguration().listener(adapter);
    }

    /**
     *  리스너 대신 인터셉터를 이용할 수도 있다.
     *
     *  인터셉터는 리스너와 비슷한 용도로 사용하지만 더욱 저수준까지 내려가 동작. 인터셉터는 statemachine의 상태 전이 중간에 interrupt하여 transition을 멈출 수 있음
     *  상태 전이를 intercept한 후, transition logic을 변경해버리는 것도 가능
     */
}
