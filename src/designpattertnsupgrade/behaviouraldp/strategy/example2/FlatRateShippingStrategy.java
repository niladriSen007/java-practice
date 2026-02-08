package designpattertnsupgrade.behaviouraldp.strategy.example2;

public class FlatRateShippingStrategy implements ShippingStrategy {

    private final int flatRate;

    public FlatRateShippingStrategy(int flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public void calculateShippingCost(int amount) {
        System.out.println("Calculating shipping cost for flat rate of $" + flatRate);
    }

}
