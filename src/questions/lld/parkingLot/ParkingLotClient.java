package questions.lld.parkingLot;

import questions.lld.parkingLot.entity.*;
import questions.lld.parkingLot.enums.SpotType;
import questions.lld.parkingLot.enums.VehicleType;
import questions.lld.parkingLot.facade.ParkingLot;
import questions.lld.parkingLot.factory.VehicleFactory;
import questions.lld.parkingLot.strategy.payment.CashPaymentStrategy;
import questions.lld.parkingLot.strategy.pricing.HourlyPricingStrategy;
import questions.lld.parkingLot.strategy.spotAllocate.NearestFirstStrategy;

import java.util.List;

public class ParkingLotClient {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(
                new NearestFirstStrategy(),
                new HourlyPricingStrategy()
        );
        ParkingFloor parkingFloor = new ParkingFloor(1);
        parkingLot.addParkingFloor(
                parkingFloor,
                List.of(
                        new ParkingSpot("F1 - S1", SpotType.SMALL),
                        new ParkingSpot("F1 - M1", SpotType.MEDIUM),
                        new ParkingSpot("F1 - L1", SpotType.LARGE)
                )
        );
        Vehicle vehicle = VehicleFactory.getVehicle(VehicleType.CAR, "KA-01-1234");
        Ticket ticket = parkingLot.parkVehicle(vehicle);
        System.out.println("Parked at position - " + ticket.getParkingSpot().getSpotId());
        Receipt receipt = parkingLot.unparkVehicle(ticket, new CashPaymentStrategy());
        System.out.println("Paid - " + receipt.getAmount() + " Rs");
    }
}
