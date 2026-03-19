package lld.ParkingLot.strategy.fees;

import lld.ParkingLot.entity.ParkingTicket;

public class HourlyFeeStrategy implements FeeStrategy {

    private final double ratePerHour;

    public HourlyFeeStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateFare(ParkingTicket parkingTicket) {
        return parkingTicket.calculateParkingDuration() * ratePerHour;
    }
}
