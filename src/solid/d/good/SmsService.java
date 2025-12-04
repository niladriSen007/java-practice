package solid.d.good;

public class SmsService implements NotificationChannel{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
