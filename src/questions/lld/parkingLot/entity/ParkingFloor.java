package questions.lld.parkingLot.entity;

import questions.lld.parkingLot.enums.SpotType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<SpotType, Queue<ParkingSpot>> freeSpots = new EnumMap<>(SpotType.class);

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        for (SpotType spot : SpotType.values()) {
            freeSpots.put(spot, new ConcurrentLinkedQueue<>());
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Map<SpotType, Queue<ParkingSpot>> getFreeSpots() {
        return freeSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        freeSpots.get(parkingSpot.getSpotType()).add(parkingSpot);
    }

    public ParkingSpot findAndClaimParkingSpot(Vehicle vehicle) {
        for (SpotType spot : SpotType.getCompatibleSpotsForVehicle(vehicle.getVehicleType())) {
            Queue<ParkingSpot> freeParkingSpots = freeSpots.get(spot);
            ParkingSpot parkingSpot;
            while ((parkingSpot = freeParkingSpots.poll()) != null) {
                if (parkingSpot.tryOccupySpot(vehicle)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }

    public void releaseParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.releaseSpot();
        freeSpots.get(parkingSpot.getSpotType()).add(parkingSpot);
    }

}
