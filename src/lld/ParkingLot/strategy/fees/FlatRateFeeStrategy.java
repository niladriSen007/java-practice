package lld.ParkingLot.strategy.fees;

import lld.ParkingLot.entity.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy {

    private final double flatRate;

    public FlatRateFeeStrategy(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculateFare(ParkingTicket parkingTicket) {
        return parkingTicket.calculateParkingDuration() * flatRate;
    }

}
