package lld.ParkingLot.entity;

import lld.ParkingLot.enums.VehicleSize;

public class Bike extends Vehicle{

    public Bike(String licensePlate) {
        super(licensePlate, VehicleSize.SMALL);
    }
}
