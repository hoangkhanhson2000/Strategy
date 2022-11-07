
package design.pattern.Strategy.strategy;
import design.pattern.Strategy.Account;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaymentByPayPal implements PaymentStrategy {

//    private String email;
//    private String password;
    BufferedReader dataIn = new BufferedReader(new
            InputStreamReader( System.in) );
    private Account account;



    @Override
    public void collectPaymentDetails() {
        // Pop-up to collect PayPal mail and password...

        try {
            System.out.print("Payment By PayPal");
            System.out.print("Enter the email:");
            String email = dataIn.readLine();
            System.out.print("Enter the password: ");
            String password = dataIn.readLine();
            account = new Account(email,password);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
//
        System.out.println("Collecting PayPal Account Details...");
    }

    @Override
    public boolean validatePaymentDetails() {

        System.out.printf("Validating PayPal Info: %s | %n", account);
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal");
    }

}

