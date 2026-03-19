package lld.notificationSystem.factory;

public class EmailNotificationFactory implements INotificationFactory {

    @Override
    public INotificationWork createNotificationWork() {
        return new EmailNotificationWork();
    }

}
