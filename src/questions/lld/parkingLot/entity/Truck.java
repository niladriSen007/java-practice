package questions.lld.parkingLot.entity;

import questions.lld.parkingLot.enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleType.TRUCK);
    }
}
