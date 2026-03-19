package lld.ParkingLot.entity;

import lld.ParkingLot.enums.VehicleSize;
import lld.ParkingLot.exception.ParkingException;

import java.util.concurrent.RecursiveTask;

public class ParkingSpot {
    private final String spotId;
    private final VehicleSize spotSize;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleSize spotSize) {
        this.spotId = spotId;
        this.spotSize = spotSize;
        this.parkedVehicle = null;
    }

    public boolean isSpotAvailable() {
        return this.parkedVehicle != null;
    }

    public boolean canBeParked(VehicleSize vehicleSize) {
        return vehicleSize.ordinal() <= this.spotSize.ordinal();
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (!isSpotAvailable()) {
            throw new ParkingException("Parking spots are not available");
        }
        if (!canBeParked(vehicle)) {
            throw new ParkingException("Vehicle size " + vehicle.getVehicleSize().name() + " won't fit in " + this.getSpotSize().name() + " space");
        }
        this.parkedVehicle = vehicle;
    }

    public synchronized Vehicle unparkVehicle() {
        if (isSpotAvailable()) {
            throw new ParkingException("Parking spot is already empty ");
        }
        Vehicle parkedVehicle1 = this.getParkedVehicle();
        this.parkedVehicle = null;
        return parkedVehicle1;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}


