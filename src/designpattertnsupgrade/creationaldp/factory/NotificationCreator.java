package designpattertnsupgrade.creationaldp.factory;

public interface NotificationCreator {
    Notification createNotification();

    default void sendNotification(String message) {
        Notification notification = createNotification();
        notification.sendNotification(message);
    }
}
