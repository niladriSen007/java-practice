package designPatterns.creational.factory;

interface Vehicle {
    void ride();
}

class Bike implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Bike is being ridden");
    }
}

class Car implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Car is being driven");
    }
}


class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "bike" -> new Bike();
            case "car" -> new Car();
            default -> throw new IllegalArgumentException("Please provide proper vehicle type");
        };
    }
}


public class Factory {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.createVehicle("Bike");
        vehicle.ride();
    }
}
