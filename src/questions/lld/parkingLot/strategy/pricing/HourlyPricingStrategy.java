package questions.lld.parkingLot.strategy.pricing;

import questions.lld.parkingLot.entity.Ticket;
import questions.lld.parkingLot.enums.VehicleType;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class HourlyPricingStrategy implements PricingStrategy {

    private static final Map<VehicleType, Double> HOURLY_RATE = Map.of(
            VehicleType.BIKE, 100.0,
            VehicleType.CAR, 150.0,
            VehicleType.TRUCK, 300.0
    );

    @Override
    public double calculateFee(Ticket ticket, Instant exitTime) {
        long parkingMinutes = Duration.between(exitTime, Instant.now()).toMinutes();
        long parkingHours = Math.max(1, (parkingMinutes + 59) / 60);
        return parkingHours * HOURLY_RATE.get(ticket.getVehicle().getVehicleType());
    }
}
