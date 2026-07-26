package questions.lld.parkingLot.entity;

import questions.lld.parkingLot.enums.SpotType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;
    private final AtomicBoolean isOccupied;
    private volatile Vehicle vehicle;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = new AtomicBoolean(false);
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return isOccupied.get();
    }

    public boolean tryOccupySpot(Vehicle vehicle) {
        // If the isOccupied flag is FALSE make it TRUE
        if (isOccupied.compareAndSet(false, true)) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public void releaseSpot() {
        this.vehicle = null;
        isOccupied.set(false);
    }
}
