package questions.lld.parkingLot.entity;

import java.time.Instant;

public class Ticket {
    private final String ticketId;
    private final ParkingSpot parkingSpot;
    private final Vehicle vehicle;
    private final Instant entryTime;

    public Ticket(String ticketId, ParkingSpot parkingSpot, Vehicle vehicle, Instant entryTime) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Instant getEntryTime() {
        return entryTime;
    }
}
