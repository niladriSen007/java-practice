package solid.o.good;

public class DebitCard implements PaymentMethod {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Debit Card");
    }
}
