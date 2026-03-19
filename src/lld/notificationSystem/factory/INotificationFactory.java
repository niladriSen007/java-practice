package lld.notificationSystem.factory;

public interface INotificationFactory {

    INotificationWork createNotificationWork();

    public default void sendNotification(String message) {
        INotificationWork notification = createNotificationWork();
        notification.sendNotification(message);
    }

}
