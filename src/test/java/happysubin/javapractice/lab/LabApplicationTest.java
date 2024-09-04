package happysubin.javapractice.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LabApplicationTest {


    @Autowired
    GenericWebApplicationContext ac;

    @Test
    void test() {
        String[] names = ac.getBeanDefinitionNames();
        System.out.println(ac.getClass());
        for (String name : names) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);
            Object bean = ac.getBean(name);
            System.out.println(bean);
            System.out.println(beanDefinition);
        }
    }

}