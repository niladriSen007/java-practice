package designpattertnsupgrade.behaviouraldp.command.good;

public class SmartHomeApp {
    public static void main(String[] args) {

        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command setTemperature = new SetTemperatureCommand(thermostat, 27);

        RemoteController controller = new RemoteController();

        System.out.println("Pressing Light On Button:");
        controller.setCommand(lightOn);
        controller.press();
        controller.undoLast();

        System.out.println("Pressing light off Button.");
        controller.setCommand(lightOff);
        controller.press();
        controller.undoLast();

        System.out.println("Changing thermostat temperature");
        controller.setCommand(setTemperature);
        controller.press();
        controller.undoLast();

    }
}
