package lld.swiggy.factory.notification;

public interface INotificationCreator {

    INotification createNotification();

    default void sendNotification(String message) {
        INotification notification = createNotification();
        notification.sendNotification(message);
    }
}
