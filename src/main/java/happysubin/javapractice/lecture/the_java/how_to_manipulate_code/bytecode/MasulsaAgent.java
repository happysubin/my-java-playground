package happysubin.javapractice.lecture.the_java.how_to_manipulate_code.bytecode;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MasulsaAgent {

    public static void premain(String agentArgs, Instrumentation inst){
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, ProtectionDomain protectionDomain) {
                        return builder.method(named("pullOut")).intercept(FixedValue.value("Rabbit!!!!!"));
                    }
                }).installOn(inst);
    }
}

/**
 * 스프링 컴포넌트 스캔을 할 때 asm을 사용한다고 한다. 뜨헉.
 * hibernate, mockito는 bytebuddy로 갈아탔다고 함.
 * 네이버 핀포인트도 이런 기술들을 접목시켰다고함. 바이트 코드를 조작한 것.
 */