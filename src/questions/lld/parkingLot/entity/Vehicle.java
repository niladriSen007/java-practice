package questions.lld.parkingLot.entity;

import questions.lld.parkingLot.enums.VehicleType;

public abstract class Vehicle {
    private final String licenseNumber;
    private final VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
