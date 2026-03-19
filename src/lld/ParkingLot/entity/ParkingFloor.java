package lld.ParkingLot.entity;

import lld.ParkingLot.enums.VehicleSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> totalSpots;

    public ParkingFloor(int floorNumber, Map<VehicleSize, Integer> sizeWiseCounts) {
        this.floorNumber = floorNumber;
        this.totalSpots = new ArrayList<>();
        initializeSpots(sizeWiseCounts);
    }

    public void initializeSpots(Map<VehicleSize, Integer> sizeWiseCounts) {
        for (VehicleSize size : VehicleSize.values()) {
            Integer count = sizeWiseCounts.getOrDefault(size, 0);
            String sizePrefix = getSizePrefix(size);
            for (int i = 0; i < count; i++) {
                String spotId = String.format("F%d-%s%03d", floorNumber, sizePrefix, i);
                totalSpots.add(new ParkingSpot(spotId, size));
            }
        }
    }

    public String getSizePrefix(VehicleSize size) {
        switch (size) {
            case VehicleSize.SMALL -> {
                return "S";
            }
            case VehicleSize.MEDIUM -> {
                return "M";
            }
            case VehicleSize.LARGE -> {
                return "L";
            }
            default -> {
                return "N";
            }
        }
    }

    public ParkingSpot findAvailableSpot(VehicleSize size) {
        for (ParkingSpot spot : this.totalSpots) {
            if (spot.isSpotAvailable() && spot.canBeParked(size)) return spot;
        }
        return null;
    }

    public int getTotalAvailableSpotsForSpecificVehicleSize(VehicleSize size) {
        int count = 0;
        for (ParkingSpot spot : this.totalSpots) {
            if (spot.isSpotAvailable() && spot.canBeParked(size)) count++;
        }
        return count;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getTotalSpots() {
        return Collections.unmodifiableList(totalSpots);
    }
}
