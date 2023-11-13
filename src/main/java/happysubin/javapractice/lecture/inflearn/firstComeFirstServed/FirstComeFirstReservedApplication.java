package happysubin.javapractice.lecture.inflearn.firstComeFirstServed;

import happysubin.javapractice.lecture.inflearn.concurrency.ConCurrencyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstComeFirstReservedApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConCurrencyApplication.class, args);
    }
}

