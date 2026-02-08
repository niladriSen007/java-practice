package designpattertnsupgrade.creationaldp.factory;

public class SmsNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }

}
