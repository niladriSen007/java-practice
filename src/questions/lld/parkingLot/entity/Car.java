package questions.lld.parkingLot.entity;

import questions.lld.parkingLot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
