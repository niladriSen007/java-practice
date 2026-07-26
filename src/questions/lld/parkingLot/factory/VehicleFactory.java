package questions.lld.parkingLot.factory;

import questions.lld.parkingLot.entity.Vehicle;
import questions.lld.parkingLot.enums.VehicleType;

public interface VehicleFactory {
    public Vehicle supplyVehicle(String licenseNumber);

    public static Vehicle getVehicle(VehicleType vehicleType, String licenseNumber) {
        return switch (vehicleType) {
            case CAR -> new CarFactory().supplyVehicle(licenseNumber);
            case TRUCK -> new TruckFactory().supplyVehicle(licenseNumber);
            case BIKE -> new BikeFactory().supplyVehicle(licenseNumber);
        };
    }
}
