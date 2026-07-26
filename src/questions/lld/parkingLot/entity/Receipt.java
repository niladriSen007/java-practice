package questions.lld.parkingLot.entity;

import java.time.Instant;

public class Receipt {
    private final Ticket ticket;
    private final double amount;
    private final Instant exitTime;

    public Receipt(Ticket ticket, double amount, Instant exitTime) {
        this.ticket = ticket;
        this.amount = amount;
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getAmount() {
        return amount;
    }

    public Instant getExitTime() {
        return exitTime;
    }
}
