package lld.swiggy.factory.order;

public class ScheduledOrderFactory implements IOrderFactory {
    @Override
    public IOrder createOrder() {
        return new ScheduledOrder();
    }

}
