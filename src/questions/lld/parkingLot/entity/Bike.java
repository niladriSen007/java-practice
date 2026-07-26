package questions.lld.parkingLot.entity;

import questions.lld.parkingLot.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String licenseNumber) {
        super(licenseNumber, VehicleType.BIKE);
    }
}
