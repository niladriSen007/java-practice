package designpattertnsupgrade.behaviouraldp.strategy.example2;

public class ShippingContext {

    private final ShippingStrategy shippingStrategy;

    public ShippingContext(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public void calculateShippingCost(int amount) {
        shippingStrategy.calculateShippingCost(amount);
        System.out.println("Shipping cost calculated successfully");
    }

}
