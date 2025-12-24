package designPatterns.creational.factory.good;

public interface NotificationCreator {
    public Notification createNotification();

    public default void send(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
