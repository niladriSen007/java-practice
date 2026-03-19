package lld.ParkingLot.strategy.spots;

import lld.ParkingLot.entity.ParkingFloor;
import lld.ParkingLot.entity.ParkingSpot;
import lld.ParkingLot.enums.VehicleSize;

import java.util.List;

public class NearestFirst implements SpotReservationStrategy {

    @Override
    public ParkingSpot findParkingSpot(List<ParkingFloor> floors, VehicleSize size) {
        for (ParkingFloor floor : floors) {
            ParkingSpot availableSpot = floor.findAvailableSpot(size);
            if (availableSpot != null) return availableSpot;
        }
        return null;
    }
}
