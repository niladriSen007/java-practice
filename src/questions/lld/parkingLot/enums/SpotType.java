package questions.lld.parkingLot.enums;

public enum SpotType {
    SMALL,
    MEDIUM,
    LARGE;

    public static SpotType[] getCompatibleSpotsForVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BIKE -> new SpotType[]{SMALL, MEDIUM, LARGE};
            case CAR -> new SpotType[]{MEDIUM, LARGE};
            case TRUCK -> new SpotType[]{LARGE};
        };
    }
}
