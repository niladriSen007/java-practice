package lld.notificationSystem.factory;

public class SmsNotificationWork implements INotificationWork {

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification " + message);
    }

}
