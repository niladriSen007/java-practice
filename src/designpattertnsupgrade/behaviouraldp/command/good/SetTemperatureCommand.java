package designpattertnsupgrade.behaviouraldp.command.good;

public class SetTemperatureCommand implements Command {
    private final Thermostat thermostat;
    private int previousTemperature;
    private final int temperature;

    public SetTemperatureCommand(Thermostat thermostat, int temp) {
        this.thermostat = thermostat;
        this.temperature = temp;
    }

    @Override
    public void execute() {
        this.previousTemperature = thermostat.getTemperature();
        thermostat.setTemperature(temperature);
        System.out.println("Thermostat temperature set to - " + this.temperature);
    }

    @Override
    public void undo() {
        thermostat.setTemperature(previousTemperature);
        System.out.println("Thermostat temperature set back to " + this.temperature);
    }

}
