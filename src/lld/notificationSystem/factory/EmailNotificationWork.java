package lld.notificationSystem.factory;

public class EmailNotificationWork implements INotificationWork {

    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notification " + message);
    }

}
