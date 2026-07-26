package questions.lld.parkingLot.strategy.pricing;

import questions.lld.parkingLot.entity.Ticket;

import java.time.Instant;

public interface PricingStrategy {
    public double calculateFee(Ticket ticket, Instant exitTime);
}
