package designPatterns.strategy;

public class CreditCard implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println(STR."Processing credit card payment of $\{amount}");
    }
}
