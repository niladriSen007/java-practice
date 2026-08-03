package questions.lld.parkingLot.facade;

import questions.lld.parkingLot.entity.*;
import questions.lld.parkingLot.strategy.payment.PaymentStrategy;
import questions.lld.parkingLot.strategy.pricing.PricingStrategy;
import questions.lld.parkingLot.strategy.spotAllocate.SpotAllocationStrategy;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ParkingLot {
    private final List<ParkingFloor> parkingFloors;
    private final SpotAllocationStrategy spotAllocateStrategy;
    private final PricingStrategy pricingStrategy;
    private final Map<String, Ticket> activeTickets;
    private final Map<String, ParkingSpot> spotIndex;
    private final AtomicLong ticketSeq = new AtomicLong(1000);

    public ParkingLot(SpotAllocationStrategy spotAllocateStrategy, PricingStrategy pricingStrategy) {
        this.spotAllocateStrategy = spotAllocateStrategy;
        this.pricingStrategy = pricingStrategy;
        this.activeTickets = new ConcurrentHashMap<>();
        this.spotIndex = new ConcurrentHashMap<>();
        this.parkingFloors = new CopyOnWriteArrayList<>();
    }

    public void addParkingFloor(ParkingFloor floor, List<ParkingSpot> spots) {
        for (ParkingSpot spot : spots) {
            floor.addParkingSpot(spot);
            spotIndex.put(String.valueOf(spot.getSpotId()), spot);
        }
        parkingFloors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot claimedParkingSpot = spotAllocateStrategy.findAndClaim(parkingFloors, vehicle);
        if (claimedParkingSpot == null) {
            throw new RuntimeException("Parking spot full");
        }
        Ticket ticket = new Ticket("T - " + ticketSeq.incrementAndGet(), claimedParkingSpot, vehicle, Instant.now());
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public Receipt unparkVehicle(Ticket ticket, PaymentStrategy paymentStrategy) {
        Ticket ticket1 = activeTickets.get(ticket.getTicketId());
        if (ticket1 == null) {
            throw new RuntimeException("Wrong ticket");
        }
        double payingAmount = pricingStrategy.calculateFee(ticket, Instant.now());
        if (!paymentStrategy.pay(payingAmount)) {
            throw new RuntimeException("Payment failed");
        }
        activeTickets.remove(ticket.getTicketId());
        ParkingSpot parkingSpot = spotIndex.get(ticket.getParkingSpot().getSpotId());
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingSpot.getSpotId().startsWith("F" + parkingFloor.getFloorNumber() + " -")) {
                parkingFloor.releaseParkingSpot(parkingSpot);
                break;
            }
        }
        return new Receipt(ticket, payingAmount, Instant.now());
    }
}
