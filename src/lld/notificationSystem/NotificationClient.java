package lld.notificationSystem;

import lld.notificationSystem.decorator.INotification;
import lld.notificationSystem.decorator.Signature;
import lld.notificationSystem.decorator.SimpleNotification;
import lld.notificationSystem.decorator.TimeStamp;
import lld.notificationSystem.factory.EmailNotificationFactory;
import lld.notificationSystem.factory.SmsNotificationFactory;
import lld.notificationSystem.observer.Logger;

public class NotificationClient {
    public static void main(String[] args) {
        NotificationService notificationService = NotificationService.getInstance();

        Logger logger = new Logger();

        NotificationEngine engine = new NotificationEngine();
        engine.addNotificationFactory(new EmailNotificationFactory());
        engine.addNotificationFactory(new SmsNotificationFactory());

        INotification notification = new SimpleNotification("Your order has been shipped!");
        notification = new TimeStamp(notification);
        notification = new Signature(notification, "Niladri");

        notificationService.sendAnsStoreNotification(notification);

    }
}
