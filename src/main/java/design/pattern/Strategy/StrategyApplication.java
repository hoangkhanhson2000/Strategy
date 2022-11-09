package design.pattern.Strategy;

import design.pattern.Strategy.strategy.PaymentByCreditCard;
import design.pattern.Strategy.strategy.PaymentByPayPal;
import design.pattern.Strategy.strategy.PaymentStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class StrategyApplication {

    public static void main(String[] args) {

        SpringApplication.run(StrategyApplication.class, args);



    }

    @Bean
    public void test() {
        System.out.println("Please Enter Your Type:(credit/paypal)");

        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String type = "";
        try {
            type = dataIn.readLine();
        } catch (IOException e) {
            System.out.println("Error!");
        }
        PaymentStrategy payment = PaymentService.getPayment(PaymentType.valueOf(type));
        payment.collectPaymentDetails();
        payment.validatePaymentDetails();
        payment.pay(100);
//        payment.validatePaymentDetails();

    }
}
