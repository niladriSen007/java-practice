package lld.ParkingLot.strategy.spots;

import lld.ParkingLot.entity.ParkingFloor;
import lld.ParkingLot.entity.ParkingSpot;
import lld.ParkingLot.enums.VehicleSize;

import java.util.List;

@FunctionalInterface
public interface SpotReservationStrategy {
    ParkingSpot findParkingSpot(List<ParkingFloor> floors, VehicleSize size);
}
