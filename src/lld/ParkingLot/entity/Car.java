package lld.ParkingLot.entity;

import lld.ParkingLot.enums.VehicleSize;

public class Car extends Vehicle{
    public Car(String licensePlate){
        super(licensePlate, VehicleSize.MEDIUM);
    }
}
