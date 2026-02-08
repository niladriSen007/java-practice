package designpattertnsupgrade.behaviouraldp.strategy.example2;

public class Client {
    public static void main(String[] args) {
        ShippingContext shippingContext;

        shippingContext = new ShippingContext(new FlatRateShippingStrategy(10));
        shippingContext.calculateShippingCost(100);

        shippingContext = new ShippingContext(new WeightBasedShippingStrategy(10));
        shippingContext.calculateShippingCost(100);
    }
}
