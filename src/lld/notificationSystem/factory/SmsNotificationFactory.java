package lld.notificationSystem.factory;

public class SmsNotificationFactory implements INotificationFactory {

    @Override
    public INotificationWork createNotificationWork() {
        return new SmsNotificationWork();
    }

}
