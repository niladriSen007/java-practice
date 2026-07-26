package questions.lld.parkingLot.factory;

import questions.lld.parkingLot.entity.Truck;
import questions.lld.parkingLot.entity.Vehicle;

public class TruckFactory implements VehicleFactory {
    @Override
    public Vehicle supplyVehicle(String licenseNumber) {
        return new Truck(licenseNumber);
    }
}
