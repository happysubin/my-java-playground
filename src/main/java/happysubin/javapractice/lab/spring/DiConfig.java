package happysubin.javapractice.lab.spring;

import io.micrometer.core.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Optional;

@Configuration
public class DiConfig {

    static class O {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "O{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


//    //호출 안됨
//    @Autowired(required = false)
//    public void setNoBean1(O o) {
//        System.out.println("setNoBean1 = " + o);
//    }
//    //null 호출
//    @Autowired
//    public void setNoBean2(@Nullable O o) {
//        System.out.println("setNoBean2 = " + o);
//    }
//    //Optional.empty 호출
//    @Autowired(required = false)
//    public void setNoBean3(Optional<O> o) {
//        System.out.println("setNoBean3 = " + o);
//    }


    @Bean
    @Primary
    public O o1() {
        O o = new O();
        o.setName("main");
        return o;
    }

    @Bean
    @Qualifier("sub")
    public O o2() {
        O o = new O();
        o.setName("sub");
        return o;
    }

    static class Z {
        private final O o;

        public Z(O o) {
            this.o = o;
        }
    }

    @Bean
    public Z z(@Qualifier("sub") O o) {
        System.out.println(o.toString());
        Z z = new Z(o);
        return z;
    }

    @Bean
    public Z z1(List<O> os) {
        System.out.println("===");
        for (O o : os) {
            System.out.println(o);
        }
        System.out.println("===");
        return null;
    }

}
