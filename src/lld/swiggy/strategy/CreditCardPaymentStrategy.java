package lld.swiggy.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " using credit card");
    }

}
