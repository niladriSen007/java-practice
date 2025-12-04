package solid.d.good;

public class EmailService implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email with message: " + message);
    }
}
