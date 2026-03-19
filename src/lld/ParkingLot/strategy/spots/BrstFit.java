package lld.ParkingLot.strategy.spots;

import lld.ParkingLot.entity.ParkingFloor;
import lld.ParkingLot.entity.ParkingSpot;
import lld.ParkingLot.enums.VehicleSize;

import java.util.List;

public class BrstFit implements SpotReservationStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingFloor> floors, VehicleSize size) {

        // here we are checking for the actual spot size which is same as the vehicle size
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getTotalSpots()) {
                if (spot.isSpotAvailable() && spot.getSpotSize() == size) {
                    return spot;
                }
            }
        }

        // here we are checking the min greater spot which will fir the Vehicle
        for (VehicleSize spotSize : VehicleSize.values()) {
            if (spotSize.ordinal() < size.ordinal()) continue;
            for (ParkingFloor floor : floors) {
                for (ParkingSpot spot : floor.getTotalSpots()) {
                    if (spot.isSpotAvailable() && spot.getSpotSize() == spotSize) return spot;
                }
            }
        }

        return null;
    }
}
