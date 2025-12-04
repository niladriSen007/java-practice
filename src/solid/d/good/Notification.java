package solid.d.good;

public class Notification {
    private NotificationChannel channel;

    public Notification(NotificationChannel channel) {
        this.channel = channel;
    }

    static void main() {
        Notification emailNotification = new Notification(new EmailService());
        emailNotification.send("Hello via Email!");

        Notification smsNotification = new Notification(new SmsService());
        smsNotification.send("Hello via SMS!");
    }

    public void send(String message) {
        channel.sendNotification(message);
    }
}
