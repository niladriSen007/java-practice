package designPatterns.observer;

public class Main {
    public static void main(String[] args) {

        Station station = new Station();

        Mobile mobile1 = new Mobile();
        Tab tab1 = new Tab();

        station.addConsumer(mobile1);
        station.addConsumer(tab1);

        station.updateTemperature(25);

        station.removeConsumer(tab1);

        station.updateTemperature(30);
    }
}
