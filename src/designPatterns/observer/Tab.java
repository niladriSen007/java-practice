package designPatterns.observer;

public class Tab implements Consumer{
    @Override
    public void update(float temperature) {
        System.out.println("Tab: Temperature updated to " + temperature + "°C");
    }
}
