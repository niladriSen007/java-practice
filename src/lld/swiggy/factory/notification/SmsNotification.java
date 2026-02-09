package lld.swiggy.factory.notification;

public class SmsNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }

}
