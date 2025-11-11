package designPatterns.observer;

public class Mobile implements Consumer{

    @Override
    public void update(float temperature) {
        System.out.println("Mobile notified. New Temperature: " + temperature);
    }
}
