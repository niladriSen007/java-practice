package lld.swiggy.factory.notification;

public class EmailNotificationFactory implements INotificationCreator {
    @Override
    public INotification createNotification() {
        return new EmailNotification();
    }
}
