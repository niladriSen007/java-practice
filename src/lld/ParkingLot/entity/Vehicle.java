package lld.ParkingLot.entity;

import lld.ParkingLot.enums.VehicleSize;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleSize vehicleSize;

    protected Vehicle(String licensePlate, VehicleSize vehicleSize) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty");
        }
        this.licensePlate = licensePlate;
        this.vehicleSize = vehicleSize;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    @Override
    public String toString() {
        return licensePlate + vehicleSize.toString();
    }
}
