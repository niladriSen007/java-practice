package designpattertnsupgrade.behaviouraldp.strategy.example1;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void executePayment(int amount) {
        System.out.println("Executing credit card payment of amount: " + amount);
    }

}
