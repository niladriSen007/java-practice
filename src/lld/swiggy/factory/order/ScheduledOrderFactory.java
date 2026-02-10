package lld.swiggy.factory.order;

public class ScheduledOrderFactory implements IOrderFactory {

    private final String scheduledTime;

    public ScheduledOrderFactory(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    @Override
    public IOrder createOrder() {
        return new ScheduledOrder(scheduledTime);
    }

}
