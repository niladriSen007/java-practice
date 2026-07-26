package questions.lld.parkingLot.strategy.spotAllocate;

import questions.lld.parkingLot.entity.ParkingFloor;
import questions.lld.parkingLot.entity.ParkingSpot;
import questions.lld.parkingLot.entity.Vehicle;

import java.util.List;

public class NearestFirstStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot findAndClaim(List<ParkingFloor> parkingFloors, Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            ParkingSpot parkingSpot = floor.findAndClaimParkingSpot(vehicle);
            if (parkingSpot != null) return parkingSpot;
        }
        return null;
    }
}
