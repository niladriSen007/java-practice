package questions.lld.parkingLot.strategy.payment;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double price) {
        return true;
    }
}
