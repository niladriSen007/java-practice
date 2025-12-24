package designPatterns.creational.factory.good;

@FunctionalInterface
public interface Notification {
    public void send(String message);
}
