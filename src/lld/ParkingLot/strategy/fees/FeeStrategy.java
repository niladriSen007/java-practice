package lld.ParkingLot.strategy.fees;

import lld.ParkingLot.entity.ParkingTicket;

@FunctionalInterface
public interface FeeStrategy {
    public double calculateFare(ParkingTicket  parkingTicket);
}
