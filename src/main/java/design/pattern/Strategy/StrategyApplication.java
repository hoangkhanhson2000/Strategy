package design.pattern.Strategy;

import design.pattern.Strategy.strategy.PaymentByCreditCard;
import design.pattern.Strategy.strategy.PaymentByPayPal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class StrategyApplication {

    public static void main(String[] args) {

        SpringApplication.run(StrategyApplication.class, args);
        PaymentService paymentService = new PaymentService();


        paymentService.setStrategy(new PaymentByCreditCard());
        paymentService.processOrder(170);

        System.out.println("==========================================");

        paymentService.setStrategy(new PaymentByPayPal());
        paymentService.processOrder(100);
    }

}
