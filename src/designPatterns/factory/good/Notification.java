package designPatterns.factory.good;

@FunctionalInterface
public interface Notification {
    public void send(String message);
}
