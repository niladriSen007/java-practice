package solid.o.bad;

public class ProcessPayment {
    public void processPayment(String paymentMethod, int amount) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing credit card payment of amount: " + amount);
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing PayPal payment of amount: " + amount);
        } else if (paymentMethod.equals("bitcoin")) {
            System.out.println("Processing Bitcoin payment of amount: " + amount);
        } else {
            System.out.println("Unsupported payment method");
        }
    }
}
