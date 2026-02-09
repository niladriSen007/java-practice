package lld.swiggy.strategy;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " using debit card");
    }

}
