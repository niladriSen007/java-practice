package designPatterns.factory.good;

public class SMSNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
