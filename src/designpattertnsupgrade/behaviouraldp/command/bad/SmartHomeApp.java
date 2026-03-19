package designpattertnsupgrade.behaviouraldp.command.bad;

public class SmartHomeApp {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        RemoteController controller = new RemoteController(light, thermostat);

        controller.turnOnLight();
        controller.turnOffLight();

        controller.setThermostatTemperature(22);
    }
}
