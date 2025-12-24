package designPatterns.factory.bad;

class EmailNotification {
    public void send(String message) {
        System.out.println("Sending an Email notification..." + message);
    }
}

class SMSNotification {
    public void send(String message) {
        System.out.println("Sending an SMS notification..." + message);
    }
}

public class NotificationService {
    static void main() {
        sendNotification("EMAIL", "Hello via Email!");
    }

    public static void sendNotification(String type, String message) {
        if(type.equals("EMAIL")) {
            EmailNotification emailNotification = new EmailNotification();
            emailNotification.send(message);
        } else if(type.equals("SMS")) {
            SMSNotification smsNotification = new SMSNotification();
            smsNotification.send(message);
        } else {
            System.out.println("Unknown notification type");
        }
    }
}
