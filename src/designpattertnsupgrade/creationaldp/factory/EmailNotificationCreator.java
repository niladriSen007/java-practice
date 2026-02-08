package designpattertnsupgrade.creationaldp.factory;

public class EmailNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }

}
