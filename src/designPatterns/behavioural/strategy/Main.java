package designPatterns.behavioural.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        PaymentStrategy paymentStrategy = new CreditCard();
        paymentService.setPaymentStrategy(paymentStrategy);
        paymentService.pay(100);
    }
}
