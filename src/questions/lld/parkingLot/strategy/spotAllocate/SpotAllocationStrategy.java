package questions.lld.parkingLot.strategy.spotAllocate;

import questions.lld.parkingLot.entity.ParkingFloor;
import questions.lld.parkingLot.entity.ParkingSpot;
import questions.lld.parkingLot.entity.Vehicle;

import java.util.List;

public interface SpotAllocationStrategy {
    public ParkingSpot findAndClaim(List<ParkingFloor> parkingFloors, Vehicle vehicle);
}
