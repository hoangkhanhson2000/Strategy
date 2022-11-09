
package design.pattern.Strategy;

import design.pattern.Strategy.strategy.PaymentByCreditCard;
import design.pattern.Strategy.strategy.PaymentByPayPal;
import design.pattern.Strategy.strategy.PaymentStrategy;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class PaymentService {

    private int cost;
    private boolean includeDelivery = true;

    private PaymentStrategy strategy;

    public void processOrder(int cost) {
        this.cost = cost;
        strategy.collectPaymentDetails();
        if (strategy.validatePaymentDetails()) {
            strategy.pay(getTotal());
        }
    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }

    public static PaymentStrategy getPayment(PaymentType paymentType) {
        return switch (paymentType) {
            case credit -> new PaymentByCreditCard();
            case paypal -> new PaymentByPayPal();

            default -> throw new IllegalArgumentException("This payment type is unsupported");
        };
    }

}

