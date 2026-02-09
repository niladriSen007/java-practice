package lld.swiggy.factory.order;

public class InstantOrderFactory implements IOrderFactory {

    @Override
    public IOrder createOrder() {
        return new InstantOrder();
    }
}
