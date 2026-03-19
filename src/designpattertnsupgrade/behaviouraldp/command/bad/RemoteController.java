package designpattertnsupgrade.behaviouraldp.command.bad;

public class RemoteController {
    private final Light light;
    private final Thermostat thermostat;

    public RemoteController(Light light, Thermostat thermostat) {
        this.light = light;
        this.thermostat = thermostat;
    }

    public void turnOnLight() {
        light.on();
    }

    public void turnOffLight() {
        light.off();
    }

    public void setThermostatTemperature(int temp) {
        thermostat.setTemperature(temp);
    }
}
