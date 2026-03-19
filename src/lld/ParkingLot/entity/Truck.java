package lld.ParkingLot.entity;

import lld.ParkingLot.enums.VehicleSize;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleSize.LARGE);
    }
}
