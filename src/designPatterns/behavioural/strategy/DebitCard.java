package designPatterns.behavioural.strategy;

public class DebitCard implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of $" + amount);
    }
}
