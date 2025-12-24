package designPatterns.creational.factory.good;

public class EmailNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
