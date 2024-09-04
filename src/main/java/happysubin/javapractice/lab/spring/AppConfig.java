package happysubin.javapractice.lab.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false) //싱글톤 보장 X
//@Configuration
public class AppConfig {


    @Bean
    public A a() {
        System.out.println("a");
        return new A(c());
    }


//    이걸 포함하면 c가 3번 출력
//    @Bean
//    public B b() {
//        System.out.println("b");
//        return new B(c());
//    }

    //이렇게 하면 c가 2번 출력
    @Bean
    public B b(C c) {
        System.out.println("b");
        return new B(c);
    }

    @Bean
    public C c() {
        System.out.println("c");
        return new C();
    }


    static class A {
        private C c;

        public A(C c) {
            this.c =
                    c;
        }
    }

    static class B {
        private C c;

        public B(C c) {
            this.c = c;
        }
    }

    static class C {

    }
}
