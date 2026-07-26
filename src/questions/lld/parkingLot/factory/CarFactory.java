package questions.lld.parkingLot.factory;

import questions.lld.parkingLot.entity.Bike;
import questions.lld.parkingLot.entity.Car;
import questions.lld.parkingLot.entity.Vehicle;

public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle supplyVehicle(String licenseNumber) {
        return new Car(licenseNumber);
    }
}
