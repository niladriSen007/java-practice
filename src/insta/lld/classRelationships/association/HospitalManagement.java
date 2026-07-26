package insta.lld.classRelationships.association;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Room {
    private String number;
    private int floor;

    public Room(String number, int floor) {
        this.number = number;
        this.floor = floor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

class Appointment {
    private Doctor doctor;
    private final Patient patient;
    private Room room;
    //    private LocalDateTime time;
    private String time;

    public Appointment(Doctor doctor, Patient patient, Room room, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
        this.time = time;
        doctor.addAppointment(this);
        patient.addAppointment(this);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

class Doctor {
    private final String name;
    private final List<String> specialization;
    private final List<Appointment> appointments;

    public Doctor(String name, List<String> specialization) {
        this.name = name;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getSpecialization() {
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
}

class Patient {
    private final String name;
    private final List<Appointment> appointments;

    public Patient(String name) {
        this.name = name;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
}


public class HospitalManagement {
    public static void main(String[] args) {
        Doctor drSmith = new Doctor("Dr. Smith", List.of("Cardiology"));
        Doctor drPatel = new Doctor("Dr. Patel", List.of("Neurology"));

        Patient alice = new Patient("Alice");
        Patient bob = new Patient("Bob");

        Room room101 = new Room("101", 1);
        Room room205 = new Room("205", 2);

        new Appointment(drSmith, alice, room101, "9:00 AM");
        new Appointment(drSmith, bob, room101, "10:00 AM");
        new Appointment(drPatel, alice, room205, "2:00 PM");

        System.out.println(drSmith.getName() + "'s Appointments:");
        for (Appointment a : drSmith.getAppointments()) {
            System.out.println("  - " + a.getTime());
        }

        System.out.println(alice.getName() + "'s appointments:");
        for (Appointment a : drSmith.getAppointments()) {
            System.out.println("  - " + a.getTime());
        }

        System.out.println(drSmith.getName() + "'s schedule:");
        for (Appointment a : drSmith.getAppointments()) {
            System.out.println("  - with " + a.getPatient().getName()
                    + " in Room " + a.getRoom().getNumber() + " at " + a.getTime());
        }
    }
}

