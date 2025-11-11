package solid.o.good;

public class Upi implements PaymentMethod{

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using UPI");
    }
}
