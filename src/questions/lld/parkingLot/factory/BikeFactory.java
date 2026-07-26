package questions.lld.parkingLot.factory;

import questions.lld.parkingLot.entity.Bike;
import questions.lld.parkingLot.entity.Vehicle;

public class BikeFactory implements VehicleFactory {
    @Override
    public Vehicle supplyVehicle(String licenseNumber) {
        return new Bike(licenseNumber);
    }
}
