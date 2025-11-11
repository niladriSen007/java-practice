package solid.o.good;

public class CreditCard implements PaymentMethod{
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit Card");
    }
}
