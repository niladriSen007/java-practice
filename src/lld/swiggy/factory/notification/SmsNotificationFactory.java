package lld.swiggy.factory.notification;

public class SmsNotificationFactory implements INotificationCreator {
    @Override
    public INotification createNotification() {
        return new SmsNotification();
    }
}
