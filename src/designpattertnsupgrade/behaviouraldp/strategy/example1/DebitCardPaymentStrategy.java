package designpattertnsupgrade.behaviouraldp.strategy.example1;

public class DebitCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void executePayment(int amount) {
        System.out.println("Executing debit card payment of amount: " + amount);
    }

}
