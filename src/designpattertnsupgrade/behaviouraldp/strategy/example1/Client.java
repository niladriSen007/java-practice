package designpattertnsupgrade.behaviouraldp.strategy.example1;

public class Client {
    public static void main(String[] args) {

        PaymentContext paymentContext;

        paymentContext = new PaymentContext(new CreditCardPaymentStrategy());
        paymentContext.executePayment(100);

        paymentContext = new PaymentContext(new DebitCardPaymentStrategy());
        paymentContext.executePayment(200);
    }
}
