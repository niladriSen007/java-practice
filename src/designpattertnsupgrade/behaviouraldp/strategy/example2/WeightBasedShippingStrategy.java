package designpattertnsupgrade.behaviouraldp.strategy.example2;

public class WeightBasedShippingStrategy implements ShippingStrategy {

    private final int pricePerKg;

    public WeightBasedShippingStrategy(int pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public void calculateShippingCost(int amount) {
        System.out.println("Calculating shipping cost for weight of " + amount + " kg at $" + pricePerKg + " per kg");
    }

}
