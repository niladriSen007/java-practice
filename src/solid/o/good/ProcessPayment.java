package solid.o.good;

public class ProcessPayment {
    public static void main(String[] args) {
        ProcessPayment processor = new ProcessPayment();

        PaymentMethod creditCardPayment = new CreditCard();
        PaymentMethod debitCardPayment = new DebitCard();
        PaymentMethod upiPayment = new Upi();

        processor.processPayment(creditCardPayment, 100);
        processor.processPayment(debitCardPayment, 200);
        processor.processPayment(upiPayment, 300);
    }

    public void processPayment(PaymentMethod paymentMethod, int amount) {
        paymentMethod.pay(amount);
    }
}
