package lld.ParkingLot.strategy.fees;

import lld.ParkingLot.entity.ParkingTicket;
import lld.ParkingLot.enums.VehicleSize;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleSize, Integer> ratesPerVehiclePerHour;

    public VehicleBasedFeeStrategy(Map<VehicleSize, Integer> ratesPerVehiclePerHour) {
        this.ratesPerVehiclePerHour = ratesPerVehiclePerHour;
    }

    @Override
    public double calculateFare(ParkingTicket parkingTicket) {
        return parkingTicket.calculateParkingDuration() * this.ratesPerVehiclePerHour.getOrDefault(
                parkingTicket.getVehicle().getVehicleSize(), 100
        );
    }
}
