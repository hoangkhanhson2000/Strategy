
package design.pattern.Strategy.strategy;


import design.pattern.Strategy.CreditCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaymentByCreditCard extends BasePayment {

    BufferedReader dataIn = new BufferedReader(new
            InputStreamReader( System.in) );
    private CreditCard card;

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Payment By Credit Card | ");
            System.out.print("Enter the card number: ");
            String number = dataIn.readLine();
            System.out.print("Enter the card expiration date 'mm/yy': ");
            String date = dataIn.readLine();
            System.out.print("Enter the CVV code: ");
            String cvv = dataIn.readLine();
            card = new CreditCard(number, date, cvv);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public boolean validatePaymentDetails() {
        // Validate credit card...
        System.out.println("Validating Card Info: " + card);
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit Card");
        card.setAmount(card.getAmount() - amount);
    }

}

